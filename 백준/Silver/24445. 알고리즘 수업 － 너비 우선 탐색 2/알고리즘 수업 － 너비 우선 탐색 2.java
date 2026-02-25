import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점
        
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1];
        
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u); // 무방향
        }
        
        // 내림차순 정렬
        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i], (a,b) -> {
                return b-a;
            });
        }
        
        bfs(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(order[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            order[node] = count++;
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}