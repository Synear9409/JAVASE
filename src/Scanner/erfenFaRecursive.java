package Scanner;
import java.util.Scanner;
/**
 * @Author Synear
 * @Date  2020年8月28
 * 二分法查找 递归形式
 *

 * 记录一下：犯下的脑残错误
 * 若递归中就找到了想找的值，请记得 "return" 回去，不然它会一直往下运行到代码块结束
 * 真的傻逼
 */
public class erfenFaRecursive {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[] arr = {10,20,30,40,50,60,70,80,90};
        String[] str = scanner.nextLine().split(",");
        int[] arr = new int[str.length];
        for(int i = 0;i < arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int index = findNum(arr,0,arr.length - 1,70);
        System.out.println(index);
    }
    public static int findNum(int[] arr,int minIndex,int maxIndex,int ele){
        int centerIndex = (minIndex+maxIndex) / 2;
        if(minIndex > maxIndex){
            return -1;    ///即递归结束
        }
        if(ele == arr[centerIndex]){
            return centerIndex;
        }else if(ele < arr[centerIndex]){
            return findNum(arr, minIndex, centerIndex - 1, ele);
        }else{
            return findNum(arr, centerIndex + 1, maxIndex, ele);
        }
    }
}
