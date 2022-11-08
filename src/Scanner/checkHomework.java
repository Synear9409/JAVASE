package Scanner;
import java.util.Scanner;

/**
 * @Author Synear
 * @Date  2020年8月28
 * 题目描述:
 * 小明想给老师当助教从而得一些补助。 老师会给小明一些作业让他去批改，并按批改的作业份数和批改
 * 正确率来确定小明的补助费。
 * 老师是这么规定的，批改-份作业小明会得到m元，如果该份作业批改完全正确那么会从中扣除k元复
 * 查费:如果批改中出现了错误会从中扣除x元当惩罚费用，此时这份作业不再扣除复查费。但是老师觉
 * 得小明勤工助学不容易，不想扣过多的费用，于是规定如果有一份作业批改错误扣了x元， 那么可以抵
 * 消一份批改正确作业的复查费。举例，如果有两份作业，-份批改正确份批改错误，那么错误的那份
 * 小明可以得到m-x元，正确的那份小明可以得到m元，不用扣复查费。
 * 最后，你能算出小明一共能得多少补助么?
 *
 */
public class checkHomework {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        checkHomework checkHomework = new checkHomework();
        checkHomework.check();
    }

    public void check(){
        ///第一行输入的数据  n m x k  样例：4 5 2 1
        String[] input1 = scanner.nextLine().split(" ");
        ////总共改了多少份试卷
        int n = Integer.parseInt(input1[0]);
        ///改一份试卷的奖金
        int m = Integer.parseInt(input1[1]);
        ///改错一份扣的金额
        int x = Integer.parseInt(input1[2]);
        ///老师检查你改的怎么样的费用
        int k = Integer.parseInt(input1[3]);

        ///改对试卷的数量
        int rightNum = 0;
        ///改错试卷的数量
        int wrongNum = 0;
        ///第二行输入的数据 1代表正确  0代表错误   样例：1 1 1 0      最后结果收入为：16
        String[] input2 = scanner.nextLine().split(" ");
        for(String i : input2){
            if(i.equals("0")){
                wrongNum++;
            }else{
                rightNum++;
            }
        }
        //收入计算
        if(rightNum >= wrongNum){
            System.out.println("小明收入为：" + (n * m - wrongNum * x - k * (rightNum-wrongNum)));
        }else{
            System.out.println("小明收入为：" + (n * m - wrongNum * x));
        }
    }
}
