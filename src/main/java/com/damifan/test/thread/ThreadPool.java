package com.damifan.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author wanglei
 * @email wanglei59
 * @create 2017/10/11 18:30
 * <p>
 * TODO
 */
public class ThreadPool {
    //用blockingQueue创建一个任务队列，初始化长度为5
    private BlockingQueue<Runnable> tasksQueue = new ArrayBlockingQueue<Runnable>(5);
    //定义线程池中消费者最大数量
    private int consumers = 3;

    //这个方法提供给所有的任务生产者，产生新的任务插入
    public void insertTask(Runnable task) throws InterruptedException {
        tasksQueue.put(task);
    }

    //线程池的初始化
    ThreadPool() {
        //激活消费者，等待问题到来
        for (int i = 1; i <= consumers; i++) {
            Solver consumer = new Solver(tasksQueue, i);
            consumer.start();
        }
    }
}
