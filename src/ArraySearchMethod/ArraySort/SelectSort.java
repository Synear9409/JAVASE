package ArraySearchMethod.ArraySort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,0,68,60};
        for(int i = 0;i < arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}