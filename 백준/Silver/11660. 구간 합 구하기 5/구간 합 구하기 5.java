import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 표 크기
        int M = Integer.parseInt(st.nextToken()); // 합 구하는 횟수
        
        int[][] table = new int[N+1][N+1];
        
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // prefix[i][j] = (1,1)부터 (i,j)까지의 합
        int[][] prefix = new int[N+1][N+1];
        
        // 2차원 누적합
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                prefix[i][j] = prefix[i-1][j] 
                             + prefix[i][j-1] 
                             - prefix[i-1][j-1] 
                             + table[i][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int answer = prefix[x2][y2]
                       - prefix[x1-1][y2]
                       - prefix[x2][y1-1]
                       + prefix[x1-1][y1-1];
                     
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
    }
}