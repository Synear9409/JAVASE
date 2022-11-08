package ArraySearchMethod.ArraySort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,0,68,60,100,98};
        long before = System.currentTimeMillis();
        for(int i = 0;i < arr.length -1;i++){
            for(int j = 0; j < arr.length-1-i;j++){   // 优化写法，原写法为：arr.length-1
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long after = System.currentTimeMillis();
        long resut = after-before;
        System.out.println(Arrays.toString(arr)+"用时："+resut);

    }
}
