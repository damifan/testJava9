package com.damifan.test.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class DelayedItem<T> implements Delayed {

    private T t;
    private long liveTime;
    private long removeTime;

    public DelayedItem(T t, long liveTime) {
        this.t = t;
        this.liveTime = liveTime;
        this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(removeTime - System.nanoTime(), unit);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) return 1;
        if (o == this) return 0;
        if (o instanceof DelayedItem) {
            DelayedItem<T> tmpDelayedItem = (DelayedItem<T>) o;
            if (liveTime > tmpDelayedItem.liveTime) {
                return 1;
            } else if (liveTime == tmpDelayedItem.liveTime) {
                return 0;
            } else {
                return -1;
            }
        }
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1 : diff == 0 ? 0 : -1;
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public int hashCode() {
        return t.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof DelayedItem) {
            return object.hashCode() == hashCode() ? true : false;
        }
        return false;
    }

}

