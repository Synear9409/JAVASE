package Nowcoder.tencent;

import java.util.Scanner;

/**
 * 题目描述：
 小Q定义了一种数列称为翻转数列:
 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
  //编程角度：
 例如n = 8, m = 2,
        数列就是: -1, -2, -3, -4, -5, -6, -7, -8
        ======》
        -1, -2, +3, +4, -5, -6, +7, +8    //规律：2 6   间隔：2m
      n = 12. m = 3
        -1, -2, -3, -4, -5, -6 -7 -8 -9 -10 -11 -12
        ======》
        -1, -2, -3, +4, +5, +6 -7 -8 -9 +10 +11 +12  //规律: 3 9  间隔：2m
 // 单纯从数学角度去想：规律：(-1,-2,3,4) 为一组   共 n/2m组   一组的和为：m*m  总和= n/2m * m*m = m*n/2
 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.          //规律: 1 3  间隔：2m
 小Q现在希望你能帮他算算前n项和为多少。

 * 输入描述：
 * 输入包括两个整数n和m(2 <= n <= 109, 1 <= m), 并且满足n能被2m整除。
 * 输出描述:
 * 输出一个整数, 表示前n项和。
 *
 * 输入例子1：
 * 8 2
 * 输出例子1:
 * 8
 */
public class practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        if (n % (2*m) == 0){
            printNum(n,m);
            //若只从数学角度： 直接代公式算即可
           //System.out.println("前"+n+"项和为："m * n / 2);
        }else {
            System.out.println("输入错误！");
        }
    }

    private static void printNum(long n, long m) {
        int[] num = new int[(int) n];
        long result = 0;
        int index = 0;
        for(int i = -1;i >= -n;i--){
            num[index] = i;
            index++;
        }
        for(long j = m;j <= n-1;j += (2*m)){
            long ids = j;
            for(int o = 0;o < m;o++){
                num[(int) ids] = Math.abs(num[(int) ids]);
                ids++;
            }
        }
        for(long k : num){
            result += k;
//            System.out.print(k+" ");
        }
        System.out.println("前"+n+"项和为：" + result);
    }
}
