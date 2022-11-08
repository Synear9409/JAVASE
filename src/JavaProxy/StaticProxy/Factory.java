package JavaProxy.StaticProxy;


public class Factory {
    private Factory(){}

    public static <T> T getInstance(String className,Class<T> clazz,T obj){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor(clazz).newInstance(obj);
		} catch (Exception e) {
			e.printStackTrace();
        }
        return instance; 
    }
}