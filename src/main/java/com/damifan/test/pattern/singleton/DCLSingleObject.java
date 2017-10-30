package com.damifan.test.pattern.singleton;

/**
 * @author wanglei
 * @create 2017/10/26 16:47
 * <p>
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class DCLSingleObject {

    //创建 SingleObject 的一个对象
    private volatile static DCLSingleObject instance;

    //让构造函数为 private，这样该类就不会被实例化
    private DCLSingleObject() {
    }

    //获取唯一可用的对象
    public static DCLSingleObject getInstance() {
        if (instance == null) {
            synchronized (DCLSingleObject.class) {
                if (instance == null) {
                    instance = new DCLSingleObject();
                }
            }
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
