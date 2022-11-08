package Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Synear
 * @Date  2020年8月29
 * 二、杀手
 * 有n个杀手排成一行，每个杀手都有一个不同的编号(编号为1-n)，在每个夜晚，杀手都会行动，如果某个杀手编号大于他右边的杀手的编号，他就会杀死他右边的杀手，杀手是的行动是瞬间的，因此一个人可能某一个夜晚既杀死了别人又被别人杀死，例如3,2,1这个顺序，在第一个夜晚2会杀死1，同时3也会杀死2。显而易见，一段时间之后，就不会有人杀或被杀，平安夜也就到来了，请问在平安夜之前有多少个夜晚。
 *
 * 输入
 * 输入第一行是一个整数n（1≤n≤100000）,表示杀手的数量。
 * 接下来一行有n个数，是一个1-n的全排列。
 * 输出
 *
 * 输出包含一个整数，表示平安夜之前经历了多少个夜晚。
 * 样例输入
 * 10
 * 10 9 7 8 6 5 3 4 2 1
 * 样例输出
 * 2
 *
 * 样例解释： 样例1中杀手的变化为[10 9 7 8 6 5 3 4 2 1]->[10 8 4]->[10]，故答案为2。
 *
 * 补充样例
 * 输入样例2：
 * 6
 *
 * 1 2 3 4 5 6
 * 输出样例2 ：
 *
 * 0
 */
public class killer {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<Integer> killer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            killer.add(scanner.nextInt());
        }
        int count = getCountDay(killer,n);
        if( count == -1){
            System.out.println("输入有误！");
        }

        System.out.println("恭喜你，" + count + "天已过,进入平安夜~\n今夜无杀戮");
    }

    private static int getCountDay(List<Integer> killer,int n) {
        int count = 0;
        if(killer.size() == 0){
            return -1;
        }
        for (int i = killer.size() - 1; i > 0; i--) {
            if(killer.get(i) < killer.get(i-1)){
                killer.remove(i);
            }
        }
        count++;
        if(killer.size() <= 1){
            return count;
        }
        if(killer.size() == n){
            return 0;
        }
        return count + getCountDay(killer,killer.size());
    }
}
