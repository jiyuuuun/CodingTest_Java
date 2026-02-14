import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 길이
        
        long[][] dp = new long[N+1][10]; // 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
        int MOD = 1000000000;
        
        // 초기값
        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }
        
        for (int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][1] % MOD; // 0은 앞에 1만 올 수 있음
            dp[i][9] = dp[i-1][8] % MOD; // 9는 앞에 8만 올 수 있음
            
            for (int j=1; j<=8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }
        
        long sum = 0;
        for (int i=0; i<=9; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }
        
        System.out.println(sum);
        
    }
}