import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 앱 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 메모리
        
        int[] memory = new int[N]; // 사용 중인 메모리
        int[] cost = new int[N]; // 비활성화 비용
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int sumCost = 0;
        for (int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sumCost += cost[i];
        }
        
        // dp[i] = 비용이 i일 때 확보 가능한 최대 메모리
        int[] dp = new int[sumCost+1];
        
        for (int i=0; i<N; i++) {
            for (int j=sumCost; j>=cost[i]; j--) {
                // 현재 앱을 사용하지 않는 경우 vs 현재 앱을 사용하는 경우
                dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
            }
        }
        
        for (int i=0; i<=sumCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}