import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = Integer.MIN_VALUE;
        int n = 0;
        int m = 0;
        
        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (max < num) {
                    max = num;
                    n = i+1;
                    m = j+1;
                }
            }
        }
        
        System.out.println(max);
        System.out.println(n + " " + m);
    }
}