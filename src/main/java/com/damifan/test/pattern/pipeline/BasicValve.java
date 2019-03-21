package com.damifan.test.pattern.pipeline;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/1/18
 */
public class BasicValve implements Valve {
    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }

    @Override
    public void invoke(String handling) {
        handling = handling.replaceAll("aa", "bb");
        System.out.println("基础阀门处理完后：" + handling);
    }
}
