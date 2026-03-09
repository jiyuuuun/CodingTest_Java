import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] dist;
    static final int INF = 1000000000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 도시 개수
        m = Integer.parseInt(br.readLine()); // 버스 개수
        
        dist = new int[n+1][n+1];
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) dist[i][j] = 0; // 자기 자신으로 가는 비용은 0
                else dist[i][j] = INF;
            }
        }
        
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용
            
            // 기존 값과 비교해서 더 작은 비용 저장
            dist[a][b] = Math.min(dist[a][b], c);
        }
        
        // 플로이드 위셜 알고리즘
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발
                for (int j = 1; j <= n; j++) { // 도착
                    // i -> k -> j 경로가 존재할 때만 계산
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        // 기존 i->j 비용과
                        // i->k->j 비용 중 더 작은 값 선택
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 도달할 수 없는 경우 0 출력
                if (dist[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}