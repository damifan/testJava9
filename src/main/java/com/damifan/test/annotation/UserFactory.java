package com.damifan.test.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/1/15
 */
public class UserFactory {

    public static User create() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
//        Field[] fields = User.class.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Init.class)) {
//                Init init = field.getAnnotation(Init.class);
//                user.setUsername(init.value());
//
//            }
//        }
        Method[] methods = User.class.getDeclaredMethods();
        for (Method m :
                methods) {
            if (m.isAnnotationPresent(Init.class)) {
                Init init = m.getAnnotation(Init.class);
                m.invoke(user, init.value());
            }
        }
        return user;
    }

    public static void main(String[] args) throws
            IllegalArgumentException, InvocationTargetException, IllegalAccessException {
        User user = UserFactory.create();

        System.out.println(user.getUsername());
        System.out.println(user.getAddress());
    }
}
