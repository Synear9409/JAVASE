import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        int[] val1 = new int[(int) n];
        int[] val2 = new int[(int) m];
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i < n; i++){
             val1[i] = scanner.nextInt();
        }
        for(int i = 0 ;i < m; i++){
            val2[i] = scanner.nextInt();
        }
        if(m > n || m < n){
            for (int i = 0; i < m ; i++) {
                if(val1[i] > val2[i]){
                    continue;
                }
                if(val1[i] == val2[i-1]){
                    res.add(val1[i]);
                }
            }
        }else{
            for (int i = 0; i < m ; i++) {
                if(val1[i] == val2[i]){
                    res.add(val1[i]);
                }
            }
        }
        Object num[] = res.toArray();
        Arrays.sort(num);
        for(Object i : num){
            System.out.println(i +" ");
        }
    }
}
