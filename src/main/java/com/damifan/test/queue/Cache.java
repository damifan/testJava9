package com.damifan.test.queue;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class Cache<K, V> {

    public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();
    public DelayQueue<DelayedItem<K>> queue = new DelayQueue<>();


    public void put(K k, V v, long liveTime) {
        V v2 = map.put(k, v);
        DelayedItem<K> tempItem = new DelayedItem<>(k, liveTime);
        if (v2 != null) {
            queue.remove(v2);
        }
        queue.put(tempItem);
    }

    public Cache() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                dameonCheckOverdueKey();
            }
        };

        thread.setDaemon(true);
        thread.start();
    }

    public void dameonCheckOverdueKey() {
        while (true) {
            DelayedItem<K> delayedItem = queue.poll();
            if (delayedItem != null) {
                map.remove(delayedItem.getT());
                System.out.println(System.nanoTime() + " remove " + delayedItem.getT() + " from cache");
            }

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int cacheNumber = 10;
        int liveTime = 10;
        Cache<String, Integer> cache = new Cache<>();
        for (int i = 0; i < cacheNumber; i++) {
            liveTime = random.nextInt(3000);
            System.out.println(i + "  " + liveTime);
            cache.put(i + "", i, random.nextInt(liveTime));
            if (random.nextInt(cacheNumber) > 7) {
                liveTime = random.nextInt(3000);
                System.out.println(i + "  " + liveTime);
                cache.put(i + "", i, random.nextInt(liveTime));
            }

        }

        Thread.sleep(3000);
        System.out.println();


    }

}
