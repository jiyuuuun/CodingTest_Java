import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 삼각형 크기
        
        int[][] dp = new int[n][n];
        
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<=i; j++) {
                int value = Integer.parseInt(st.nextToken());
                
                // 왼쪽 끝
                if (j==0) {
                    dp[i][j] = (i==0) ? value : dp[i-1][j] + value;
                } 
                // 오른쪽 끝
                else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + value;
                }
                // 중간
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + value;
                }
            }
        }
        
        int answer = 0;
        for (int j=0; j<n; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        System.out.println(answer);
    }
}