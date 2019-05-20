package com.damifan.test.abstractTest;

import java.util.Comparator;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/18
 */
public class BigRice<T> extends AbstractRice<T> implements Comparator, Comparable {

    @Override
    public void color(String color) {
        super.color(color);
    }

    public static void main(String[] args) {
        BigRice bigRice = new BigRice();

        bigRice.color("white");
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
