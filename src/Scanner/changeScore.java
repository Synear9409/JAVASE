package Scanner;

import java.util.Scanner;

/**
 * @Author Synear
 * @Date  2020年8月28
 *
 * 一、改成绩
 * 华老师的n个学生参加了一次模拟测验，考出来的分数很糟糕，但是华老师可以将成绩修改为[0,100]中的任意值，
 * 所以他想知道，如果要使所有人的成绩的平均分不少于X分，至少要改动多少个人的分数？
 *
 * 输入
 * 第一行一个数T，共T组数据（T≤10）
 * 接下来对于每组数据：
 * 第一行两个整数n和X。（1≤n≤1000, 0≤X≤100）
 * 第二行n个整数，第i个数Ai表示第i个学生的成绩。（0≤Ai≤100）
 * 输出
 *
 * 共T行，每行一个整数，代表最少的人数。
 * 样例输入
 * 2
 * 5 60
 * 59 20 30 90 100
 * 5 60
 * 59 20 10 10 100
 * 样例输出
 * 1 2
 */
public class changeScore {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int i = 0;i < T;i++){
            System.out.println("n");
            int n = scanner.nextInt();
            System.out.println("X");
            int X = scanner.nextInt();
            int[] record = new int[n];
            for (int j = 0; j < n; j++) {
                System.out.println("record");
                record[j] = scanner.nextInt();
            }
            System.out.println(updateNum(record,n,X));
        }
    }
    ////修改成绩的次数
    private static int updateNum(int[] record, int n, int X) {
        int count = 0;
        while (checkAverage(record) < X){
            int index = selectMinNum(record);
            record[index] = 100;
            count++;
        }
        return count;
    }

    ///找出数据中最小数字的下标
    private static int selectMinNum(int[] record) {
        int index = 0;
        for (int i = 1; i < record.length ; i++) {
            if(record[index] > record[i]){
                index = i;
            }
        }
        return index;
    }

    ///计算平均值
    private static int checkAverage(int[] record) {
        int result = 0;
        for (int i = 0; i < record.length; i++) {
            result += record[i];
        }
        return result / record.length;
    }
}
