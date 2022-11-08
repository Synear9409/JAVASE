package ArraySearchMethod.ArraySort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,11,-1,0,40,5,5};
        chaifen(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void chaifen(int[] arr, int startIndex, int endIndex) {
        int centerIndex = (startIndex+endIndex)/2;
        if(startIndex < endIndex){
            chaifen(arr, startIndex, centerIndex);
            chaifen(arr, centerIndex+1,endIndex);
            guibing(arr, startIndex, centerIndex, endIndex);
        }
    }

    private static void guibing(int[] arr, int startIndex, int centerIndex, int endIndex) {
        int[] tempArr = new int[endIndex-startIndex+1];
        int i = startIndex;
        int j = centerIndex+1;
        int index = 0;
        while(i<=centerIndex && j<=endIndex){
            if(arr[i] <= arr[j]){
                tempArr[index] = arr[i];
                i++;
            }else{
                tempArr[index] = arr[j];
                j++;
            }
            index++;
        }
        ///处理剩余元素
        while(i <= centerIndex){
            tempArr[index] = arr[i];
            i++;
            index++;
        }
        while(j <= endIndex){
            tempArr[index] = arr[j];
            j++;
            index++;
        }

        for(int k = 0;k<tempArr.length;k++){
            arr[k+startIndex] = tempArr[k];
        }
    }
}