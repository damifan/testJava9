package com.damifan.test.thread;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/20
 */
public class ThreadLocalTest {

    private static ThreadLocal<Object> threadLocal = ThreadLocal.withInitial(() -> {
        System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
        return null;
    });

    public static void main(String[] args) {
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
        new Thread(new MyStringTask("StringTask2")).start();

    }


    public static class MyIntegerTask implements Runnable {

        private String name;

        public MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == threadLocal.get()) {
                    threadLocal.set(0);
                    System.out.println("线程" + name + ": 0");

                } else {
                    int num = (int) threadLocal.get();
                    threadLocal.set(num + 1);
                    System.out.println("线程" + name + ": " + threadLocal.get());
                    if (i == 3) {
                        threadLocal.remove();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class MyStringTask implements Runnable {

        private String name;

        public MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == threadLocal.get()) {
                    threadLocal.set("a");
                    System.out.println("线程" + name + ": a");

                } else {
                    String str = (String) threadLocal.get();
                    threadLocal.set(str + "a");
                    System.out.println("线程" + name + ": " + threadLocal.get());

                }

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
