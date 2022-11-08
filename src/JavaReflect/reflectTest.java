package JavaReflect;

/**
 * 反射与工厂设计模式
 */
public class reflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
      NetMessage nms = Factory.getInstance("JavaReflect.NetMessageImp", NetMessage.class);
      nms.send();
      CloudMessage cms = Factory.getInstance("JavaReflect.CloudMessageImp", CloudMessage.class);
      cms.send();
    }
}

class Factory {
    private Factory() {};   ///没有产生实例化对象的意义，所以私有化

    /**
     * 获取接口实例化对象
     * @param className  接口的子类
     * @param clazz     描述的是一个接口的类型
     * @return     返回指定接口的实例化对象
     * 
     * 
     * getDeclaredConstructor(Class<?>... parameterTypes) 
     * 这个方法会返回制定参数类型的所有构造器，包括public的和非public的，当然也包括private的。
     * getDeclaredConstructors()的返回结果就没有参数类型的过滤了。
     * 
     * getConstructor(Class<?>... parameterTypes)
       这个方法返回的是上面那个方法返回结果的子集，只返回制定参数类型访问权限是public的构造器。
       getConstructors()的返回结果同样也没有参数类型的过滤
     */
    public static <T> T getInstance(String className,Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}

interface NetMessage{
    public void send();
}

interface CloudMessage{
    public void send();
}

class NetMessageImp implements NetMessage{

    @Override
    public void send() {
        System.out.println("【网络消息】www.Synear.com");
    }
}


class CloudMessageImp implements CloudMessage{

    @Override
    public void send() {
        System.out.println("【云消息】www.Synear.com");
    }

}

