package Nowcoder.tencent;

import java.util.Scanner;

/**
 * 题目：
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
 * 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 *
 * 输入
 * 5       222333
 *        100000
 * 2 3 3 3
 * 输出
 * 9
 *
 *   10000|0   j=5  i=0
 *   1000|00         j=4  i=0
 *   100|000       j=3  i=0
 *   10|1000       j=2  i=0
 *
 *   101000   j=5  i=1
 *   101010         j=4  i=1
 *   101010       j=3  i=1
 *   102010       j=2  i=1
 *
 *   102010   j=5  i=2
 *   102030         j=4  i=2
 *   102030       j=3  i=2
 *   103030       j=2  i=2
 *
 *   103030     100300
 *
 *   103133
 *   103236
 *   103339
 */
public abstract class practice6 {
    public static final int ASD = 1000000007;

    public void test(){

    }
    public static void main(String[] args){
        String str = null;
        System.out.println(str);
        Scanner scn = new Scanner(System.in);

        int k = scn.nextInt();
        int a = scn.nextInt();
        int x =  scn.nextInt();
        int b=  scn.nextInt();
        int y =  scn.nextInt();
        int[] dp = new int[k+1];
        dp[0]=1;
        for(int i =0;i<x;i++){
            for(int j=k;j>=a;j--){
                 dp[j]=(dp[j]+dp[j-a])%ASD;//53 42 31 20
            }
        }
        for (int i = 0;i<y;i++){
            for(int j=k;j>=b;j--){
                dp[j]=(dp[j]+dp[j-b])%ASD;//52 41 30
            }
        }
        System.out.println(dp[k]);
        scn.close();
    }
}
