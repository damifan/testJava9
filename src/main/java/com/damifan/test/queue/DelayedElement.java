package com.damifan.test.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class DelayedElement implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.toSeconds(1);
    }

    @Override
    public int compareTo(Delayed o) {
        return 1;
    }
}
