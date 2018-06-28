package com.damifan.test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/27.
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println("args = [" + threadLocalRandom.nextInt(99999, 1000000) + "]");
    }
}
