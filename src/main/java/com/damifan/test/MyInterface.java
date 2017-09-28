package com.damifan.test;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/9/27 13:20
 * <p>
 * TODO
 */
public interface MyInterface {

    void normalInterfaceMethod();

    default void interfaceMethodWithDefault() {
        init();
    }

    default void anotherDefaultMethod() {
        init();
    }

    /**
     * This method is not part of the public API exposed by {@link com.damifan.test.MyInterface}
     */
    private void init() {
        System.out.println("Initializing");
    }


}

