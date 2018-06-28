package com.damifan.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/27.
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < 10; i++) {
            map.put("key" + i, i);
        }

        for (Map.Entry<String, Integer> entrySet: map.entrySet()) {
            System.out.println("args = [" + entrySet.getKey() + ":" + entrySet.getValue() + "]");
        }

        for (String key: map.keySet()) {
            System.out.println("args = [" + key + ":" + map.get(key) + "]");
        }

        map.forEach((k, v) -> System.out.println("args = [" + k + ":-----" + v + "]"));


    }
}
