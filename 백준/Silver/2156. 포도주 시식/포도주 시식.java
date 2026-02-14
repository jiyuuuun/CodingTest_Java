import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 포도주 잔 개수
        
        int[] size = new int[n+1];
        int[] dp = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            size[i] = Integer.parseInt(br.readLine());
        }
        
        if (n==1) {
            System.out.println(size[1]);
            return;
        }
        
        dp[1] = size[1];
        dp[2] = size[1] + size[2];
        
        for (int i=3; i<=n; i++) {
            dp[i] = Math.max(
                dp[i-1], // i번째 잔을 안 마시는 경우
                Math.max(
                    dp[i-2] + size[i],  // i번째 잔만 마시는 경우
                    dp[i-3] + size[i-1] + size[i] // i-1, i 두 잔을 연속으로 마시는 경우
                )
            );
        }
        
        System.out.println(dp[n]);
    }
}