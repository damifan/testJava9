package com.damifan.test.queue;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/11.
 */
public class EndExam extends Student {

    private DelayQueue<Student> students;
    private CountDownLatch countDownLatch;
    private Thread teacherThread;


    public EndExam(DelayQueue<Student> students, long workTime, CountDownLatch countDownLatch, Thread teacherThread) {
        super("强制收卷", workTime, countDownLatch);
        this.students = students;
        this.countDownLatch = countDownLatch;
        this.teacherThread = teacherThread;
    }

    @Override
    public void run() {
        teacherThread.interrupt();
        Student tempStudent;
        for (Iterator<Student> iterator2 = students.iterator(); iterator2.hasNext(); ) {
            tempStudent = iterator2.next();
            tempStudent.setForce(true);
            tempStudent.run();
        }

        countDownLatch.countDown();
    }
}
