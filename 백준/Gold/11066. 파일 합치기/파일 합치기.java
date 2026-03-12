import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine()); // 파일(장) 개수
            int[] files = new int[K+1]; // 파일 크기 저장 (1번부터 사용)
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 파일 크기 입력
            for (int i=1; i<=K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }
            
            // sum[i] = 1번 ~i번 파일까지의 크기 합
            int[] sum = new int[K+1];
            
            for (int i=1; i<=K; i++) {
                sum[i] = sum[i-1] + files[i];
            }
            
            // dp[i][j] = i번 파일부터 j번 파일까지 하나로 합치는 최소 비용
            int[][] dp = new int[K+1][K+1];
            
            // 구간 길이 기준으로 DP 진행
            // len = 합칠 파일 개수
            for (int len=2; len<=K; len++) {
                for (int i=1; i<=K-len+1; i++) { // 구간 시작점
                    int j = i + len - 1; // 구간 끝
                    
                    dp[i][j] = Integer.MAX_VALUE; // 초기화
                    
                    // i~j 구간을 k 기준으로 나눔
                    // (i ~ k) + (k+1 ~ j)
                    for (int k=i; k<j; k++) {
                        dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1]
                        );
                    }
                }
            }
            
            System.out.println(dp[1][K]);
        }
    }
}