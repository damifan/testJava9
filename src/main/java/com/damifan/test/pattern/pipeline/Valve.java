package com.damifan.test.pattern.pipeline;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/1/18
 */
public interface Valve {
    public Valve getNext();

    void setNext(Valve valve);

    void invoke(String handling);

}
