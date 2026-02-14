import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        // dp[i] = i를 1로 만드는 데 필요한 최소 연산 횟수
        int[] dp = new int[N+1]; 
        dp[1] = 0;
        
        for (int i=2; i<=N; i++) {
            // 1을 빼는 경우 (항상 가능)
            dp[i] = dp[i-1] + 1;
            
            // 2로 나눠지는 경우
            if (i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            
            // 3으로 나눠지는 경우
            if (i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        
        System.out.println(dp[N]);
    }
}