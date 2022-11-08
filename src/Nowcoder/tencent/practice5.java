package Nowcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，
 * 但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 *
 * 输入
 * 3 7
 * 输出
 * 4
 */
public class practice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double m = sc.nextInt();
        double left = 1,right = m,center;
        boolean flag = false;
        while (left < right){
            flag = true;
            center = (int) Math.ceil((left+right)/2);
            ///现在决定要吃的数量
            double now = center;
            ///剩余的量
            double temp = m;
            for(int i = 0;i<n;i++){
                if(now > temp){
                    flag = false;
                    break;
                }
                temp -= now;
                now = Math.ceil(now/2);
            }
            if(flag){
                ///若循环完 代表center可以初定作为第一天吃的量，然后继续while循环，找到最多能吃的值
                left = center;
            }else{
                ///false 则说明第一天吃的值太大，并将范围缩小到center - 1 继续进行循环
                right = center - 1;
            }
        }
        System.out.println((int)left);
    }
}
