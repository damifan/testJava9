package com.damifan.test.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @DESC :
 * @Author : WangLei
 * @Date : 2018/6/28.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            br.readLine();
        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println(e.getClass());
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
