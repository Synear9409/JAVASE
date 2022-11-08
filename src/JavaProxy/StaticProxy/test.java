package JavaProxy.StaticProxy;

public class test {
    public static void main(String[] args) {
        Message m = Factory.getInstance("JavaProxy.StaticProxy.MessageProxy",Message.class,new MessageImp());
        m.send();
        // Message mess = new MessageProxy(new MessageImp());
        // mess.send();
    }
}