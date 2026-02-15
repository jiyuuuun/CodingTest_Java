import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        
        Character[][] board = new Character[N+1][M+1];
        
        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=1; j<=M; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }
        
        // B 시작 기준
        int[][] prefix = new int[N+1][M+1];
        
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                char expected;
                
                // (i+j) 짝수 -> B, 홀수 -> W (B 시작 기준)
                if ((i+j) % 2 == 0) {
                    expected = 'B';
                } else {
                    expected = 'W';
                }
                
                int mismatch = (board[i][j] != expected) ? 1 : 0;
                
                prefix[i][j] = prefix[i-1][j]
                             + prefix[i][j-1]
                             - prefix[i-1][j-1]
                             + mismatch;
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 모든 KxK 탐색
        for (int i=K; i<=N; i++) {
            for (int j=K; j<=M; j++) {
                int repaint = prefix[i][j]
                            - prefix[i-K][j]
                            - prefix[i][j-K]
                            + prefix[i-K][j-K];
                            
                // W 시작일 경우는 전체 - repaint
                repaint = Math.min(repaint, K*K - repaint);
                
                answer = Math.min(answer, repaint);
            }
        }
        
        System.out.println(answer);
        
    }
}