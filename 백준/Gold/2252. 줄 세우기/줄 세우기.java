import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수
        
        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        
        // 인접 리스트 초기화
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 구성 + 진입차수 계산
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph[A].add(B); // A -> B
            indegree[B]++; // B의 진입차수 증가
        }
        
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        bfs(); // 위상정렬
    }
    
    // BFS 기반 위상정렬
    static void bfs() {
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            
            // 연결된 노드들의 진입차수 감소
            for (int next : graph[cur]) {
                indegree[next]--;
                
                // 진입차수가 0이 되면 큐에 추가
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}