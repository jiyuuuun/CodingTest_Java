import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        
        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
            
        }
        
        int[][] dp = new int[N+1][K+1];
        
        for (int i=1; i<=N; i++) {
            for (int w=1; w<=K; w++) {
                if (w >= weight[i]) {
                    // 현재 물건을 안 넣는 경우
                    int notTake = dp[i-1][w];
                    
                    // 현재 물건을 넣는 경우
                    int take = dp[i-1][w-weight[i]] + value[i];
                    
                    dp[i][w] = Math.max(notTake, take);
                } else {
                    // 현재 물건을 못 넣는 경우 - 이전 상태 그대로 가져옴
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}