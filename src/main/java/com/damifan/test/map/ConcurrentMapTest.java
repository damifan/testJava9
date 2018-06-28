package com.damifan.test.map;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class ConcurrentMapTest {

    private Collection<String> cachedFiles = new HashSet<>();

    private ConcurrentMap<String, CountDownLatch> cacheTimestamp = new ConcurrentHashMap<>();

    public void tryCache(String file) throws InterruptedException {
        CountDownLatch signal = cacheTimestamp.putIfAbsent(file, new CountDownLatch(1));
        if (signal == null) {
            signal = cacheTimestamp.get(file);
            try {
                if (!cachedFiles.contains(file)) {
//                    doCache(file);
                    cachedFiles.add(file);
                }
//                break;
            } finally {
                signal.countDown();
                cacheTimestamp.remove(file);
            }
        } else {
            signal.await();
        }
    }

    public static void main(String[] args) {
        ConcurrentMap concurrentMap = new ConcurrentHashMap();
        concurrentMap.put("test", "111");
        Object value = concurrentMap.get("test");
        System.out.printf(value.toString());
    }
}
