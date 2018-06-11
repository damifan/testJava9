package com.damifan.test.queue;

import java.util.concurrent.DelayQueue;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class Teacher implements Runnable {

    private DelayQueue<Student> students;

    public Teacher(DelayQueue<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        System.out.println("start test");
        while (!Thread.interrupted()) {
            try {
                students.take().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
