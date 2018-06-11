package com.damifan.test.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();

        Delayed delayed = new DelayedElement();

        delayQueue.put(delayed);

        Delayed delayed1 = delayQueue.take();

    }
}
