package JavaIO.UserLogin;

import java.util.Scanner;

public class InputUtil {


    /**
     * 实现键盘接收字符数据
     * @param prompt  提示信息
     * @return   可用使用的字符串
     */
    public static String getString(String prompt){
        String str = null;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while(flag){
            System.out.println(prompt);   ///打印提示信息
            if(input.hasNext()){   ///// 判断是否还有输入
                str = input.next().trim();
                if(!"".equals(str)){
                    flag = false;
                }else{
                    System.out.println("输入的内容不允许为空");
                }
            }else{
                System.out.println("输入的内容不允许为空");
            }
        }
        return str;
    }

    /**
     * 实现键盘接收数字
     * @param prompt  提示信息
     * @return   可用使用的字符串
     */
    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while(flag){
            System.out.println(prompt); 
            if(input.hasNext("\\d+")){
                num = Integer.parseInt(input.next("\\d+"));
                flag = false;
            }else{
                System.out.println("输入的内容不是数字");
            }
        }
        return num;
    }
}