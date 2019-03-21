package com.damifan.test.pattern.pipeline;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/1/18
 */
public interface Pipeline {
    Valve getFirst();

    Valve getBasic();

    void setBasic(Valve valve);

    void addValve(Valve valve);
}
