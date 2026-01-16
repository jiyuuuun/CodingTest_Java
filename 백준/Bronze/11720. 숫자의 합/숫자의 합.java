import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        int sum = 0;
    
        for (int i=0; i<N; i++) {
            int n = S.charAt(i) - '0';
            sum += n;
        }
        
        System.out.println(sum);
    }
}