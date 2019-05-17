package com.damifan.test.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/17
 */
public class IntLock implements Runnable {
    public static ReentrantLock reentrantLock1 = new ReentrantLock();
    public static ReentrantLock reentrantLock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                reentrantLock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reentrantLock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，执行完毕！");

            } else {
                reentrantLock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reentrantLock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，执行完毕！");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (reentrantLock1.isHeldByCurrentThread()) {
                reentrantLock1.unlock();
            }
            if (reentrantLock2.isHeldByCurrentThread()) {
                reentrantLock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "，退出。");

        }
    }


    public static void main(String[] args) throws InterruptedException {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);

        Thread thread1 = new Thread(intLock1, "线程1");
        Thread thread2 = new Thread(intLock2, "线程2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();
    }
}
