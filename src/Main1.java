import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
///12345678910
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < m;i++){
            int n = scanner.nextInt();
            list.add(n);
        }
        Arrays.sort(list.toArray());
        for(int j = 0 ;j<list.size();j++){
            int center = list.size() / 2;
            if(j < center){
                System.out.println(list.get(center));
            }else{
                System.out.println(list.get(center-1));
            }
        }
    }
}
