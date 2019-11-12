package io.dy.singleton.test;

import java.io.Serializable;

/**
 * 懒汉式线程安全-双重检测锁写法
 *  可以防止序列化与反序列化后对象不一样
 */
public class Singleton8 implements Serializable {
    // volatile 保证声明的变量不参与JVM指令的重排序
    private static volatile Singleton8 instance;

    /**
     * 具体来说instance = new Singleton8();并非原子操作，
     * 实际上被拆分为了三步：
     *     1) 分配内存；
     *     2) 初始化对象；
     *     3) 将instance指向分配的对象内存地址。
     * 如果没有volatile，可能会发生指令重排，使得instance先指向内存地址，
     * 而对象尚未初始化完成，但其它线程直接使用instance引用进行对象操作时出错。
     */


    private Singleton8(){

    }

    /**
     * 双重检测锁的写法是对方法上加锁或代码块加锁的一种性能优化，多增加一次if判断，
     * 能减少进入同步代码块的线程数从而降低竞争锁的激烈程度，
     * 减少线程阻塞切换上下文环境带来的性能损耗。
     */
    public static Singleton8 getInstance(){
        if (instance == null){
            // synchronized 已经保证了对象的可见性
            synchronized (Singleton8.class){
               if(instance ==null){
                   instance = new Singleton8();
               }
            }
        }
        return instance;
    }

    //invokeReadResolve:通过反射的方式调用要被反序列化的类的readResolve方法。
    private Object readResolve(){
        return instance;
    }
}
