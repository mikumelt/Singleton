package io.dy.singleton.test;

/**
 * 饿汉线程安全-静态代码块写法
 * 优点：无线程同步问题，线程安全
 * 缺点：类装载时创建实例，无Lazy Loading。实例一直未被使用时，会浪费资源
 */
public class Singleton5 {
    private static Singleton5 instance;

    static {
        instance = new Singleton5();
    }

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        return instance;
    }

}
