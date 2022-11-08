package JavaProxy.ActiveProxy;

public class test {
    public static void main(String[] args) {
        Class<?> className = Factory.getInstance().getClass();
        Service instance = Factory.getInstance();
        instance.fun();
        // Message mes1 = (Message) new ActiveProxy().bind(new MessageImp());
//        mes1.send();
        // Message mes = (Message) new ActiveProxy(new MessageImp()).bind();
        // mes.send();
        // Service ser = (Service) new ActiveProxy().bind(new ServiceImp());
        // ser.fun();
    }
}
