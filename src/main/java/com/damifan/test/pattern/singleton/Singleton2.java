package com.damifan.test.pattern.singleton;

/**
 * @author wanglei
 * @create 2017/10/30 18:30
 * <p>
 * TODO
 */
public class Singleton2 {
    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static final Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getMessage() {
        System.out.println("this is ...");
    }

    public static void main(String[] args) {
        Singleton2.getInstance().getMessage();
    }
}
