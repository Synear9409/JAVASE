package Singleton;
/**
 * 饿汉式 单例模式实现
 * 时间：2020/5/18 
 * 实现的三个步骤：
	1、如何阻止外部实例化本类对象   ---------构造方法私有化
	2、如何保证本类实例化对象不被重复声明创建   ---------用 final static 关键字定义属性
	3、外部如何访问本类的私有化对象  -----------定义一个static方法 有(类名).(方法) 直接访问
 */
public class HungrySingleton{

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    ////私有化构造子,阻止外部直接实例化对象
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

/*
	
*/
}