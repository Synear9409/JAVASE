package ArraySearchMethod;
import java.util.Scanner;

public class YangHuiSingle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数：");
        int n = scanner.nextInt();
        int [][] arr = new int[n][n];

        for(int i = 0;i < arr.length;i++){
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

        for(int i = 2;i<arr.length;i++){
            for(int j = 1;j < i;j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }


        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j <= i;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
    
}