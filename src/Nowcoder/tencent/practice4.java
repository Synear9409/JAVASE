package Nowcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 *
 * 输入
 * 3
 * 2 7 4
 * 输出
 * 5
 */
public class practice4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n =in.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            Arrays.sort(a);
            int sheep =0;
            int cow =0;
            for(int i=0;i < n-1;i+=2){
                cow+=a[i];
                sheep+=a[i+1];
            }
            if(n%2==1){
                cow+=a[n-1];
            }
            System.out.println(cow-sheep);
        }
    }
}
