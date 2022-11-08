
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =  scanner.nextInt();
        long[] A = new long[N];
        long[] B = new long[N];
        int maxA = 0;
        int maxB = 0;
        int centerB = 0;
        for(int i = 0;i < N;i++){
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
//        if(A.length !=N || B.length != N){
//            return;
//        }
        maxA = (int) A[0];
        Arrays.sort(B);
        int k = N-1;
        while(k>0){
            if(B[k] > maxA){
                maxB = (int) B[k];
            }
            if(B[k] == maxA){
                centerB = (int) B[k];
                maxB = centerB;
            }
            k--;
        }
        int temp = (int) B[0];
        B[0] = maxB;
        if(maxB < maxA){
            System.out.println(-1);
        }
        for(int i = 1;i<N;i++){   /// 134
            int t = (int) B[i];
            B[i] = temp;
            temp = t;
        }
        for(int j=0;j<N;j++){
            System.out.print(B[j]);
        }
    }
}
