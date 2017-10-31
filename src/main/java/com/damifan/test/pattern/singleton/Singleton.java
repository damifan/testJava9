package com.damifan.test.pattern.singleton;

/**
 * @author wanglei
 * @create 2017/10/30 18:27
 * <p>
 * TODO
 */
public enum Singleton {
    INSTANCE;

    public void whateverMethod() {
        System.out.println("this is ...");
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.whateverMethod();
    }
}
