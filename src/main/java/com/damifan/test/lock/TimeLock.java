package com.damifan.test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/17
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + " get Lock Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 查询当前线程是否保持此锁。
            if (lock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName() + " release lock");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock, "线程1");
        Thread t2 = new Thread(timeLock, "线程2");
        t1.start();
        t2.start();
    }
}
