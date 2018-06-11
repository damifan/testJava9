package com.damifan.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/7.
 */
public class BlockingQueueTest {

    /**
     * 定义装苹果的篮子
     */
    public static class Basket {
        // 篮子，能够容纳3个苹果
        BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);


        public void produce() throws InterruptedException {
            basket.put("apple");
        }

        public String consume() throws InterruptedException {
            return basket.take();
        }

        public int getAppleSize() {
            return basket.size();
        }
    }

    public static void test() {
        Basket basket = new Basket();

        class Producer implements Runnable {

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("生产者准备生产苹果" + System.currentTimeMillis());
                        basket.produce();

                        System.out.println("生产苹果完毕" + System.currentTimeMillis());

                        System.out.println("生产完苹果有" + basket.getAppleSize() + "个");
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 定义苹果消费者
        class Consumer implements Runnable {
            @Override
            public void run() {
                try {
                    while (true) {
                        // 消费苹果
                        System.out.println("消费者准备消费苹果："
                                + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕："
                                + System.currentTimeMillis());
                        System.out.println("消费完后有苹果：" + basket.getAppleSize() + "个");
                        // 休眠1000ms
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }


        ExecutorService executorService = Executors.newCachedThreadPool();

        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        executorService.submit(producer);
        executorService.submit(consumer);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();


    }


    public static void main(String[] args) {
        BlockingQueueTest.test();
    }
}
