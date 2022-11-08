package JavaProxy.StaticProxy;

public class MessageImp implements Message {

    @Override
    public void send() {
        System.out.println("【发送消息】www.Synear.com");
    }
    
}