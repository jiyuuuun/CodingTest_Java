import java.util.*;
import java.io.*;

public class Main {
    static int V,E;
    static int[][] dist;
    static final int INF = 1000000000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 마을 개수
        E = Integer.parseInt(st.nextToken()); // 도로 개수
        
        dist = new int[V+1][V+1];
        
        for (int i=1; i<=V; i++) {
            for (int j=1; j<=V; j++) {
                if (i==j) dist[i][j] = 0; // 자기 자신으로 가는 거리는 0
                else dist[i][j] = INF;
            }
        }
        
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 마을
            int b = Integer.parseInt(st.nextToken()); // 도착 마을
            int c = Integer.parseInt(st.nextToken()); // 거리
            
            // 같은 출발-도착 도로가 여러 개 있을 수 있으므로 최소값 저장
            dist[a][b] = Math.min(dist[a][b], c);
        }
        
        // 플로이드 위셜 알고리즘
        for (int k = 1; k <= V; k++) { // 경유지
            for (int i = 1; i <= V; i++) { // 출발
                for (int j = 1; j <= V; j++) { // 도착
                    // i -> k -> j 경로가 존재할 때만 계산
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        // 기존 i->j 비용과
                        // i->k->j 비용 중 더 작은 값 선택
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int answer = INF;

        // i -> j -> i 형태의 사이클 검사
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                // 서로 다른 마을이고 왕복 경로가 존재하면
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    // i -> j -> i 형태의
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }
        
        // 사이클 없는 경우
        if (answer == INF) System.out.println(-1);
        else System.out.println(answer);
    }
}