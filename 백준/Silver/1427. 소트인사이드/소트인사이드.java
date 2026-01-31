import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (int a : list) {
            System.out.print(a);
        }
    }
}