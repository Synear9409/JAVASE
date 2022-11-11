package ArraySearchMethod.ArraySort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {18,23,19,9,23,15};
        for(int i = 0;i < arr.length-1;i++){
            int s = i;
            for(int j = s+1;j<arr.length;j++){
                if(arr[s] > arr[j]){
                    s = j;
                }
            }
            if (s != i) {
                int temp = arr[s];
                arr[s] = arr[i];
                arr[i] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}


// 18,23,19,9,23,15

// 插排
// 18 23
// 18 19 23
// 9 18 19 23

// 选择排序
// 9 23 19 18 23 15
// 9 15 19 18 23 23
//

