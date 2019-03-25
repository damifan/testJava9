package com.damifan.test.thread;

/**
 * @TODO
 * @Author : WangLei
 * @Date : 2019/3/25
 */
public class ThreadGroupTest {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("Java技术栈线程线程组名称：" + Thread.currentThread().getThreadGroup());
            System.out.println("Java技术栈线程线程名称：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadGroup threadGroup = new ThreadGroup("test");
        threadGroup.setMaxPriority(Thread.MIN_PRIORITY);
        Thread myThread1 = new Thread(threadGroup, runnable, "user-task1");
        Thread myThread2 = new Thread(threadGroup, runnable, "user-task2");
        myThread1.start();
        myThread2.start();

        System.out.println("Java技术栈线程线程组活跃线程数：" + threadGroup.activeCount());
        threadGroup.list();

        myThread2.interrupt();
    }
}
