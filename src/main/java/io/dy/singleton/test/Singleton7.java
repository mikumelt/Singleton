package io.dy.singleton.test;

/**
 * 单例模式 枚举写法
 * 优点：枚举本身是线程安全的，且能防止通过反射和反序列化创建多实例。
 * 缺点：使用的是枚举类。
 */
public enum Singleton7 {
    INSTANCE;
    public static Singleton7 getInstance(){
        return INSTANCE;
    }
}
