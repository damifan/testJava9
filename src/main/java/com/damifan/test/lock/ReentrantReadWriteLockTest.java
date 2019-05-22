package com.damifan.test.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/22
 */
public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        new Thread(() -> test.get(Thread.currentThread())).start();

        new Thread(() -> test.get(Thread.currentThread())).start();
    }

    public void get(Thread thread) {
        readWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
