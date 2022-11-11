package ArraySearchMethod.ArraySort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,0,68,60,100,98};
//        long before = System.currentTimeMillis();
//        for(int i = 0;i < arr.length -1;i++){
//            boolean swapped = false;   // 优化写法2
//            for(int j = 0; j < arr.length-1-i;j++){   // 优化写法1，原写法为：arr.length-1
//                if(arr[j] > arr[j+1]){
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//        long after = System.currentTimeMillis();
//        long resut = after-before;
//        System.out.println(Arrays.toString(arr)+"用时："+resut);

        bubblingV2(arr);
    }

    // 优化最终版
    public static void bubblingV2(int[] arr) {
        int length = arr.length - 1;
        do {
            int last = 0;
            for (int i = 0; i < length; i++) {
                if (arr[i] > arr[i + 1]) {
                    System.out.println("比较了"+ i +"次");
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    last = i;
                }
            }
            length = last;
            System.out.println("冒泡~");
        } while (length != 0);
    }
}
