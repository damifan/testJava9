package com.damifan.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/10/11 18:13
 * <p>
 * TODO
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        //初始化队列长度只有3的队列
        final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        Thread Putter = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                //                    blockingQueue.put("货物" + i);
                boolean offer = blockingQueue.offer("货物" + i);
                if (!offer) {
                    System.out.println("队列已满，可放入" + blockingQueue.remainingCapacity());
                }
                System.out.println("可放入" + blockingQueue.remainingCapacity() + "成功往队列中放入货物" + i);
            }
        });

        Putter.start();

        Thread taker = new Thread(() -> {
            while (true) {
                try {
                    //取得时间延长，模拟取得时间远大于放入时间
                    Thread.sleep(3000);
                    String cargo = blockingQueue.take();
                    String cargo2 = blockingQueue.poll();
                    System.out.println("取出货物： " + cargo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        taker.start();


    }

}