import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        while (true) {
            if (N%5 == 0) {
                count += N/5;
                System.out.println(count);
                return;
            } 
                
            N -= 3;
            count++;
                
            if (N < 0) {
                System.out.println(-1);
                return;
            }
        }
    }
}