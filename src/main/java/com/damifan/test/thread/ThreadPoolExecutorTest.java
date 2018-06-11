package com.damifan.test.thread;

import java.util.concurrent.*;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/5/14.
 */
public class ThreadPoolExecutorTest {

    public static void main(String args[]) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println(r.toString());
                return null;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                if (executor.isShutdown()){
//                    r.run();
//                }

//                throw new RejectedExecutionException();

                if (!executor.isShutdown()) {
                    executor.getQueue().poll();
                    executor.execute(r);
                }
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
    }

}
