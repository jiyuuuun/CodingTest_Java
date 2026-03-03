import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 문제의 수
        M = Integer.parseInt(st.nextToken()); // 정보의 개수
        
        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        pq = new PriorityQueue<>();
        
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph[A].add(B);
            indegree[B]++;
        }
        
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        
        bfs();
        
        System.out.println(sb);
    }
    
    static void bfs() {
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }
}