import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 행렬 개수
        
        // matrix[i][0] = i번째 행렬의 행
        // matrix[i][1] = i번째 행렬의 열
        int[][] matrix = new int[N+1][2];
        
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // 행
            matrix[i][1] = Integer.parseInt(st.nextToken()); // 열
        }
        
        // dp[i][j] = i번째 행렬부터 j번째 행렬까지 곱하는 최소 연산 횟수
        int[][] dp = new int[N+1][N+1];
        
        // 곱할 행렬의 구간 길이 (len = 행렬 개수)
        for (int len=2; len<=N; len++) {
            for (int i=1; i<=N-len+1; i++) {
                int j = i + len - 1;
                
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k=i; k<j; k++) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i][k] + dp[k+1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]
                    );
                }
            }
        }
        
        System.out.println(dp[1][N]);
        
        
    }
}