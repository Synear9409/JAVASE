package JavaProxy.StaticProxy;


/**
 * 静态代理模式
 */
public class MessageProxy implements Message {

    private Message message;

    public MessageProxy(Message message){
        this.message = message;
    }

    @Override
    public void send() {
        if(this.connect()){
            this.message.send();
            this.close();
        }
    }

    public boolean connect(){
        System.out.println("连接成功！");
        return true;
    }

    public void close(){
        System.out.println("关闭连接！");
    }
}