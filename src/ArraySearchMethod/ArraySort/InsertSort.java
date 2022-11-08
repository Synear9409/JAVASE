package ArraySearchMethod.ArraySort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,0,68,60};
        for(int i = 1;i < arr.length;i++){
            for(int j = i;j > 0;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}