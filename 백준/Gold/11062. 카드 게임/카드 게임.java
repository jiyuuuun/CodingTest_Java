import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 카드 개수
            
            int[] cards = new int[N+1];
            int[][] dp = new int[N+1][N+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                dp[i][i] = cards[i]; // 카드가 1개면 그 카드 점수 그대로
            }
            
            // 카드가 2개일 때 -> 더 큰 카드 선택
            for (int i=1; i<N; i++) {
                dp[i][i+1] = Math.max(cards[i], cards[i+1]);
            }
            
            // 카드가 3개 이상일 때
            for (int len=3; len<=N; len++) {
                for (int i=1; i+len-1<=N; i++) {
                    int j = i+len-1;
                    
                    dp[i][j] = Math.max(
                        // 내가 왼쪽 카드 선택
                        cards[i] + Math.min(dp[i+2][j], dp[i+1][j-1]), // 상대가 i+1 선택, 상대가 j 선택
                        // 내가 오른쪽 카드 선택
                        cards[j] + Math.min(dp[i][j-2], dp[i+1][j-1]) // 상대가 j-1 선택, 상대가 i 서택
                    );
                }
            }
            
            System.out.println(dp[1][N]);
            
        }
        
    }
}