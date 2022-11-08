package Singleton;
public class StaticSingleton {

        private StaticSingleton() {}
    
        private static class SingletonInstance {
            private static final StaticSingleton INSTANCE = new StaticSingleton();
        }
        
        /////只有当需要实例化时，调用getInstance()方法才会装载StaticSingleton类，从而完成对象的实例化
        public static StaticSingleton getInstance() {
            return SingletonInstance.INSTANCE;
        }
}