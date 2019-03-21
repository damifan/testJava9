package com.damifan.test.jdk12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/3/21
 */
public class FilesTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp");
        if (!file.exists()) file.mkdirs();
        FileWriter fileWriter1 = new FileWriter("/tmp/a.txt");
        fileWriter1.write(1);
//        fileWriter1.write("a");
//        fileWriter1.write("b");
//        fileWriter1.write("好");
        fileWriter1.close();

        FileWriter fileWriter2 = new FileWriter("/tmp/b.txt");
        fileWriter2.write(2);
//        fileWriter2.write(2);
//        fileWriter2.write("b");
//        fileWriter2.write("不好");
        fileWriter2.close();

        System.out.println(Files.mismatch(Path.of("/tmp/a.txt"), Path.of("/tmp/b.txt")));

    }
}
