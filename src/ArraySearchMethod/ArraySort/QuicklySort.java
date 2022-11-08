package ArraySearchMethod.ArraySort;

import java.util.Arrays;

public class QuicklySort {
    public static void main(String[] args) {
        int[] arr = {1,34,45,32,10,43,70,98,11,-1,0,40,5,5};
        quickSort(arr,0,arr.length-1);
        System.err.println(Arrays.toString(arr));
    }

    ///将左右分好的部分再进行递归操作排序
    private static void quickSort(int[] arr, int start, int end) {
        if(start < end){
            int index = getIndex(arr,start,end);
            quickSort(arr, start, index-1);
            quickSort(arr, index+1, end);
        }
    }

    private static int getIndex(int[] arr, int start, int end) {

        int i = start;
        int j = end;
        int x = arr[i];

        while(i<j){
            ///由后向前找比他小的数，找到后挖出此数填到前一个坑里
            while(i<j && arr[j]>x){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            ///由前向后找比他大的数，找到后挖出此数填到前一个坑里
            while(i<j && arr[i]<x){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;

        return i;
    }
}