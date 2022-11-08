package Singleton;
/**
 * 双端检索 单例模式实现
 * 
 * volatile 类型修饰符（一旦某个线程使变量发生了改变会立即将这个值刷新到主内存中）
 * 1、保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
   2、禁止进行指令重排序。（实现有序性）
   3、volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性。
 */

public class DCheckSingleton{

    private static volatile DCheckSingleton instance;

    private DCheckSingleton(){}

    public static DCheckSingleton getInstance(){
        if(instance == null){          ///比普通懒汉式性能高的原因：第二次进来时instance已不为null，不会再执行同步块的代码，而是直接返回对象
            ////这里synchronized同步的是代码块 所以与懒汉式相比，效率更高一些
            synchronized(DCheckSingleton.class){
                if(instance == null){
                    instance = new DCheckSingleton();
                }
            }
        }
        return instance;
    }
}