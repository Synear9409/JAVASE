package Singleton;
/**
 * 懒汉式 单例模式实现
 */

public class LazySingleton {
    
    /**
     * 第一种写法（不可用---会有线程不安全的问题）
     */

/*
    private static LazySingleton instance = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
*/
    private static LazySingleton instance = null;

    private LazySingleton(){}

    ////对getInstance方法加锁，保证了同一时刻只能有一个线程访问并获得实例
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}