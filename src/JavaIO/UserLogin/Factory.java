package JavaIO.UserLogin;


///工厂类
public class Factory {
    private Factory(){}

    public static UserService getInstance(){
        return new UserServiceProxy(new UserServiceImp());
    }
}