package com.damifan.test.hash;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/7/11.
 */
public class HashTest {

    public static void main(String[] args) {
        Set set = new HashSet();

        boolean res1 = set.add("大米饭");
        boolean res2 = set.add("小米饭");

        boolean res3 = set.add("大米饭");
        boolean res4 = set.add("小米饭");


        TreeSet ts = new TreeSet();
        ts.add("ccc");
        ts.add("aaa");
        ts.add("ddd");
        ts.add("bbb");

        System.out.println(ts); // [aaa, bbb, ccc, ddd]
    }
}
