package com.damifan.test.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/17
 */
public class ReentrantLockTest {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
                System.out.println("i++:" + i);
            } finally {
                lock.unlock();
                lock.unlock();
            }
            System.out.println("i unlock:" + i);
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.run();
    }
}
