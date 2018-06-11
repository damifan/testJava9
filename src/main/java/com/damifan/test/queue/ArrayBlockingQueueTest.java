package com.damifan.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class ArrayBlockingQueueTest {


    public static void main(String args[]) throws InterruptedException {

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(10);

        ArrayBlockingQueue arrayBlockingQueue3 = new ArrayBlockingQueue(10);

        ArrayBlockingQueueTest test = new ArrayBlockingQueueTest();
        for (int i = 0; i < 11; i++) {

            arrayBlockingQueue.add(i);

            boolean offer = arrayBlockingQueue2.offer(i);
            if (!offer) {
                System.out.println("队列已满");
            }

            arrayBlockingQueue3.offer(i, 1000, TimeUnit.MILLISECONDS);

        }
    }
}
