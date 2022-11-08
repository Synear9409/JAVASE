package ArraySearchMethod.ArraySort;

import java.util.Arrays;

/**
 * 希尔排序（插入排序的升级版）
 * Knuth序列  int h =1
 *            int h = h*3 - 1
 *                 比选择数组的一半作为增量h的效率高
 */
public class HillSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,11,-1,0,40,5,5};
        long before = System.currentTimeMillis();
        /**
         * 普通方法
         */
        // for(int h = arr.length / 2;h > 0;h /= 2){
        //     for(int i = h;i < arr.length;i++){
        //         for(int j = i;j > h-1;j -= h){
        //             if(arr[j] < arr[j-h]){
        //                 int temp = arr[j-h];
        //                 arr[j-h] = arr[j];
        //                 arr[j] = temp;
        //             }
        //         }
        //     }
        // }

        /**
         * kunth序列版 希尔排序
         */
        int step = 1;
        while(step < arr.length/3){
            step = step * 3 - 1;
        }
        for(int h = step;h > 0;h=(h-1)/3){
                for(int i = h;i < arr.length;i++){
                    for(int j = i;j > h-1;j -= h){
                        if(arr[j] < arr[j-h]){
                            int temp = arr[j-h];
                            arr[j-h] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            }

        long after = System.currentTimeMillis();
        long result = after-before;
        System.out.println(Arrays.toString(arr)+"用时："+result);
    }
}