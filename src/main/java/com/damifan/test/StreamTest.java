package com.damifan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/9/20 16:25
 * <p>
 * TODO
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        String[] array = new String[stringCollection.size()];
        stringCollection.toArray(array);
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(b))
                .forEach(System.out::println);


        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true

        long c = stringCollection
                .stream()
                .distinct()
                .count();
        System.out.println(c);


        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);

        List<String> list = List.of("2", "3");

    }

}
