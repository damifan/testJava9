package com.damifan.test.leetcode;

import java.util.Arrays;

/**
 * @TODO
 * @Author : WangLei
 * @Date : 2019/3/25
 */
public class TwoSumTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 13, 14};
        int target = 9;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(Arrays.toString(new int[]{i, j}));
                    break;
                }
            }
        }
    }
}
