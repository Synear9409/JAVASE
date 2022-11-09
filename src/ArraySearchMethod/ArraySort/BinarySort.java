package ArraySearchMethod.ArraySort;

/**
 * @author SynearChen
 * @version 1.0
 * @date 2022/11/7 15:07
 * @description: 二分查找
 */
public class BinarySort {

    public static void main(String[] args) {
        int[] num = {1, 9 , 12, 18, 48, 68, 71, 73, 89, 99, 100};
        int target = 48;
        int targetIndex = binarySearch(num, target);
        System.out.println(targetIndex);
    }

    private static int binarySearch(int[] num, int target) {
        int left = 0, right = num.length - 1, middle;
        while (left <= right) {
//            middle = (left + right) / 2;  // 会出现数据溢出问题
//            middle = left + (right - left) / 2;
//            解决办法1：(l + r) / 2  ==> l/2 + r/2 ==> l + (-l/2 + r/2) ==> l + (r - l) / 2
//            解决办法2：(l + r) >>> 1
            middle = (left + right) >>> 1;
            if (num[middle] == target) {
                return middle;
            }else if (num[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }


}
