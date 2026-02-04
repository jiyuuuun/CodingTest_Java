import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽
            int M = Integer.parseInt(st.nextToken()); // 동쪽
            
            long[][] arr = new long[M+1][N+1];
            
            // 초기화
            for (int i=0; i<=M; i++) {
                arr[i][0] = 1;
                if (i<=N) arr[i][i] = 1;
            }
            
            for (int i=2; i<=M; i++) {
                for (int j=1; j<=N && j<i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            
            sb.append(arr[M][N]).append("\n");
        }
        
        System.out.println(sb);
    }
}