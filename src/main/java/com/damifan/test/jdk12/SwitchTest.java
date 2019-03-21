package com.damifan.test.jdk12;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/3/21
 */
public class SwitchTest {

    private static int getString(int obj) {
        int result = switch (obj) {
            case 1 -> 3;
            case 2 -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        };

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getString(1));
    }
}
