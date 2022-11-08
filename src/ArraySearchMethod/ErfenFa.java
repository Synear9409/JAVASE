package ArraySearchMethod;

public class ErfenFa {
    /**
     * 二分法查找
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90};
        int index = getIndexEle(arr,10);
        System.out.println(index);
    }

    private static int getIndexEle(int[] arr, int ele) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int centerIndex = (minIndex+maxIndex) / 2;
        while(minIndex <= maxIndex){
            if(ele == arr[centerIndex]){
                return centerIndex;
            }else if(ele > arr[centerIndex]){
                minIndex = centerIndex + 1;
            }else if(ele < arr[centerIndex]){
                maxIndex = centerIndex - 1;
            }
            centerIndex = (maxIndex+minIndex)/2;
        }
        return -1;
    }
}