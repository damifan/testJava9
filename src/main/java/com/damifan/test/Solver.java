package com.damifan.test;

import java.util.concurrent.BlockingQueue;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/10/11 18:31
 * <p>
 * TODO
 */
public class Solver extends Thread {

    //引用线程池的任务队列，消费者不断的从里面取得任务去解决
    private BlockingQueue<Runnable> taskQueue = null;

    String name;

    Solver(BlockingQueue<Runnable> tasks, int name) {
        this.taskQueue = tasks;
        this.name = String.valueOf(name);
    }

    public void run() {
        try {
            while (true) {
                //从队列中取出任务执行，注意这里用了take方法，所以如果队列空了，那么线程会等待，直到有任务来了，继续执行
                Runnable task = taskQueue.take();
                System.out.println("消费者" + name + "接收了一个任务");
                task.run();
                System.out.println("消费者" + name + "解决了一个任务");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
