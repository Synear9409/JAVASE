package JavaProxy.ActiveProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 */
public class ActiveProxy implements InvocationHandler {

    private Object target;   ///保存真实对象

    /**
     *
     * 进行真实业务对象与代理业务对象之间的绑定处理
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("********【执行方法】*****" + method);
        Object returnObj = null;
        if(this.connect()){
            returnObj = method.invoke(this.target, args);
            this.close();
        }
        System.out.println("********【执行方法】*****" + method);
        return returnObj;
    }

    public boolean connect(){
        System.out.println("连接成功！");
        return true;
    }

    public void close(){
        System.out.println("关闭连接！");
    }
}
