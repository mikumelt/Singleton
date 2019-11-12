package io.dy.singleton.test;

/**
 * 饿汉式线程安全-静态常量写法
 * 优点：实现简单，无线程同步问题
 * 缺点： 在类装载时完成实例化。若该实例一直未被使用，则会造成资源浪费。
 */
public class Singleton4 {
    private static final Singleton4 instance = new Singleton4();

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        return instance;
    }


}
