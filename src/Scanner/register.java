package Scanner;

import java.util.Scanner;

/**
 * @Author Synear
 * @Date  2020年8月28
 * 题目要求： 编写注册验证功能
 * 1.原系统中包括两个注册好的账号“zhangsan"和"lisi"，要求新注册的账号用户名不能已经存在，否则输出”用户名已经存在“，中止程序。
 * 2.密码必须是8到16位,且必须由数字和字母组成，否则输出”密码格式不正确“，中止程序。
 * 3.手机号码必须是11位，且开头必须是1，否则输出”请输入正确的手机号“，中止程序
 * 4.如果全部输入正确，输出”注册成功“
 *
 */
public class register {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ToRegister();
    }

    private static void ToRegister() {
        boolean flag = true;
        while(flag){
            String name = scanner.nextLine();
            if(!checkName(name,flag)){
                break;
            }
            String password = scanner.nextLine();
            if(!checkPassword(password,flag)){
                break;
            }
            String phone = scanner.nextLine();
            if(!checkPhone(phone,flag)){
                break;
            }
            System.out.println("注册成功");
            break;
        }
    }

    private static boolean checkPhone(String phone, boolean flag) {
        String patten = "^(1)\\d{10}$";
        if(!phone.matches(patten)){
            System.out.println("请输入正确的手机号!");
            flag = false;
        }
        return flag;
    }

    private static boolean checkPassword(String password, boolean flag) {
        String patten = "[a-zA-Z0-9]{8,16}";
        if(!password.matches(patten)){
            System.out.println("密码格式不正确!");
            flag = false;
        }
        return flag;
    }

    private static boolean checkName(String name, boolean flag) {
        if (name.equals("zhangsan") || name.equals("lisi")) {
            System.out.println("用户名已经存在!");
            flag = false;
        }
        return flag;
    }
}
