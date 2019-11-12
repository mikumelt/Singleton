package io.dy.singleton.test;

/**
 *懒汉模式 线程安全
 * 性能太差，高并发敏感的情景不适合
 */
public class Singleton1 {
    private static Singleton1 instance;
    private  Singleton1(){

    }
    public static synchronized Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
