package com.damifan.test.thread;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/21
 */
// YieldLockTest.java 的源码
public class YieldLockTest {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t1.join();
        t2.start();
        t2.join(11111);
        t3.start();

    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            // 获取obj对象的同步锁
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i % 4 == 0)
                        Thread.yield();
                }
            }
        }
    }
}