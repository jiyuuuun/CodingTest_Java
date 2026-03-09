import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] edges;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선 개수
        
        edges = new int[M][3];
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); // from
            edges[i][1] = Integer.parseInt(st.nextToken()); // to
            edges[i][2] = Integer.parseInt(st.nextToken()); // cost
        }
        
        dist[1] = 0;
        
        // N-1 번 반복
        for (int i=1; i<=N-1; i++) {
            for (int j=0; j<M; j++) {
                int from = edges[j][0];
                int to = edges[j][1];
                int cost = edges[j][2];
                
                if (dist[from] != INF && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
            }
        }
        
        // 음수 사이클 검사
        for (int j=0; j<M; j++) {
            int from = edges[j][0];
            int to = edges[j][1];
            int cost = edges[j][2];
            
            // 더 짧은 거리 발견 -> 음수 사이클 존재
            if (dist[from] != INF && dist[to] > dist[from] + cost) {
                System.out.println(-1);
                return;
            }
        }
        
        for (int i=2; i<=N; i++) {
            if (dist[i] == INF) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}