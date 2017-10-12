package com.damifan.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/10/11 17:21
 * <p>
 * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
 * <p>
 */
public class SchduleThreadPool {

    public static void main(String args[]) {

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("可用处理器:" + availableProcessors);

        // 延迟3秒执行，延迟执行示例代码如下：
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(availableProcessors);

        scheduledThreadPool.schedule(() -> System.out.println("delay 3 seconds"), 3, TimeUnit.SECONDS);

        //表示延迟1秒后每3秒执行一次，定期执行示例代码如下：
        ScheduledExecutorService scheduledThreadPool2 = Executors.newScheduledThreadPool(5);
        scheduledThreadPool2.scheduleAtFixedRate(() -> System.out.println("delay 1 seconds, and excute every 3 seconds"), 1, 3, TimeUnit.SECONDS);
    }
}
