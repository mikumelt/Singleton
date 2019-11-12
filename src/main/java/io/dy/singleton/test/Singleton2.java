package io.dy.singleton.test;

/**
 * 懒汉式 线程安全
 * 可用，不推荐
 * 性能依旧很差
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        synchronized (Singleton2.class){
            if (instance == null){
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
