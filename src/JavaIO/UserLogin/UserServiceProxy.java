package JavaIO.UserLogin;


///代理类
public class UserServiceProxy implements UserService{

    private UserService userService;
    
    public UserServiceProxy(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while(!this.isExit()){
            String inputData = InputUtil.getString("请输入登录信息");
            if(inputData.contains("/")){   ///输入了用户名和密码
                String temp[] = inputData.split("/");   ///数据拆分
                if(this.userService.login(temp[0], temp[1])){   ///登录验证
                    return true;
                }else{
                    System.out.println("用户名和密码错误");
                }
            }else{   ///现在只输入了用户名
                String psw = InputUtil.getString("请输入密码");
                if(this.userService.login(inputData, psw)){   ///登录验证
                    return true;
                }else{
                    System.out.println("用户名和密码错误");
                }
            }
        }
        return false;
    }   
    
}