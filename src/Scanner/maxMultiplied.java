package Scanner;

import java.util.Scanner;

/**
 * @Author Synear
 * @Date  2020年8月28
 * 题目要求： 将输入的数字n（n>=0)分解，然后让分解的数字相乘，求相乘后的最大值。
 * 例如：
 * 输入： 5
 * 输出： 6
 */
public class maxMultiplied {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        calculate();
    }

    private static void calculate() {
        long num = scanner.nextLong();
        long result = 0;
        if(num == 0){
            result = 0;
            System.out.println("乘积最大值为：" + result);
        }else if(num % 2 == 0){
            result = (num/2) * (num/2);
            System.out.println("乘积最大值为：" + result);
        }else{
            result = (num/2) * (num/2+1);
            System.out.println("乘积最大值为：" + result);
        }
    }
}
