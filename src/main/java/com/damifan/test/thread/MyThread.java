package com.damifan.test.thread;

/**
 * @TODO
 * @Author : WangLei
 * @Date : 2019/3/25
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("Java技术栈线程线程组名称：" + Thread.currentThread().getName());

    }
}
