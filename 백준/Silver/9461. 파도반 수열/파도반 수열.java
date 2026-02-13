import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        dp[1] = dp[2] = dp[3] = 1;
        
        for (int i=4; i<=100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        
        System.out.println(sb);
    }
}