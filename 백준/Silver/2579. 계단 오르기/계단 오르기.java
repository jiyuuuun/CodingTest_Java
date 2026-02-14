import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단 수
        
        int[] score = new int[n+1]; // 계단 점수
        int[] dp = new int[n+1]; // i번째 계단까지 왔을 때 최대 점수
        
        for (int i=1; i<=n; i++) {
            score[i] = Integer.parseInt(br.readLine());
            
        }
        
        if (n==1) {
            System.out.println(score[1]);
            return;
        }
        
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        
        for (int i=3; i<=n; i++) {
            dp[i] = Math.max(
                dp[i-2] + score[i], // 한 칸 건너뛰고 오는 경우
                dp[i-3] + score[i-1] + score[i] // 두 칸 연속 밟고 오는 경우
            );
        }
        
        System.out.println(dp[n]);
    }
}