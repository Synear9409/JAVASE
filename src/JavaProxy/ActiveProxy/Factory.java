package JavaProxy.ActiveProxy;

public class Factory {
    private Factory(){}

    public static <T> T getInstance(){
        return (T) new ActiveProxy().bind(new ServiceImp());
    }
}
