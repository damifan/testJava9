package com.damifan.test.thread;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/9/28 17:23
 * <p>
 * TODO
 */
public class LearnCompleteFuture {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        useFuture();

        TimeUnit.SECONDS.sleep(10);
        System.out.println();

        useCompletableFuture();
    }

    private static void useFuture() throws InterruptedException, ExecutionException {
        System.out.println("Future");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Void> futureA = executor.submit(() -> work("A1"));
        Future<Void> futureB = executor.submit(() -> work("B1"));
        while (true) {
            try {
                futureA.get(1, TimeUnit.SECONDS);
                break;
            } catch (TimeoutException e) {
            }
            try {
                futureB.get(1, TimeUnit.SECONDS);
                break;
            } catch (TimeoutException e) {
            }
        }
        executor.submit(() -> work("C1")).get();
        executor.shutdown();
    }

    private static void useCompletableFuture() throws InterruptedException, ExecutionException {
        System.out.println("CompletableFuture");
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(() -> work("A2"));
        CompletableFuture<Void> futureB = CompletableFuture.runAsync(() -> work("B2"));
        futureA.runAfterEither(futureB, () -> work("C2")).get();
    }

    public static Void work(String name) {
        System.out.println(name + " starts at " + LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
        }
        System.out.println(name + " ends at " + LocalTime.now());
        return null;
    }
}
