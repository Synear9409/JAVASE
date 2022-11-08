package JavaIO.UserLogin;

public class UserServiceImp implements UserService{
    private int count = 0;

    @Override
    public boolean isExit() {
        return this.count >= 3;
    }

    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "mldn".equals(name) && "hello".equals(password);
    }
    
}