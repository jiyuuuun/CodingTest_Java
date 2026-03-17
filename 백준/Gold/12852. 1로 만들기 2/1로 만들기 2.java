import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        int[] dp = new int[X+1]; // dp[i] : i를 1로 만드는 최소 연산 횟수
        int[] prev = new int[X+1]; // prev[i] : i로 오기 직전 숫자
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=2; i<=X; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;
            
            // 2로 나누는 경우
            if (i%2 == 0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }
            
            // 3으로 나누는 경우
            if (i%3 == 0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }
        }
        
        System.out.println(dp[X]);
        
        // prev 배열을 이용해 경로 역추적
        while (X != 0) {
            System.out.print(X + " ");
            X = prev[X];
        }
    }
}