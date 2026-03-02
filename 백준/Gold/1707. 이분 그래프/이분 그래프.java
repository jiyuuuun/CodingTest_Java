import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color; // 0: 미방문, 1: 그룹A, -1:그룹B
    static int V,E;
    static boolean isBipartite;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        StringBuilder sb = new StringBuilder();
        
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수
            
            graph = new ArrayList[V+1];
            color = new int[V+1];
            isBipartite = true;
            
            // 그래프 초기화
            for (int i=1; i<=V; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 간선 입력
            for (int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); 
                int v = Integer.parseInt(st.nextToken()); 
                
                graph[u].add(v); 
                graph[v].add(u); // 무방향
            }
            
            // 모든 정점 탐색 (그래프가 여러 덩어리일 수 있음)
            for (int i=1; i<=V; i++) {
                if (color[i] == 0) {
                    bfs(i);
                }
            }
            
            sb.append(isBipartite? "YES\n" : "NO\n");
        }
        
        System.out.println(sb);
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1; // 시작 정점은 1로 칠하기
        
        while (!q.isEmpty() && isBipartite) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                // 아직 색이 없다면 -> 반대 색으로 칠하기
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    q.add(next);
                }
                // 이미 색이 있는데 같은 색이면 -> 이분 그래프 아님
                else if (color[next] == color[cur]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}