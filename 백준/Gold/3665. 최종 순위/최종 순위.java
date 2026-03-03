import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] rank;
    static int[] indegree;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine()); // 팀의 수
            
            // 그래프 및 진입차수
            graph = new ArrayList[n+1];
            indegree = new int[n+1];
            
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 작년 순위 입력
            rank = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }
            
            // 완전 방향 그래프 구성
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    graph[rank[i]].add(rank[j]);
                    indegree[rank[j]]++;
                }
            }
            
            // 등수 변경 입력
            int m = Integer.parseInt(br.readLine()); // 등수가 바뀐 쌍의 수
            
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                // 기존 간선 방향 확인 후 뒤집기
                if (graph[a].contains(b)) {
                    graph[a].remove(Integer.valueOf(b));
                    graph[b].add(a);
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b].remove(Integer.valueOf(a));
                    graph[a].add(b);
                    indegree[a]--;
                    indegree[b]++;
                }
            }
            
            // 위상정렬
            q = new LinkedList<>();
            for (int i=1; i<=n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
            
            bfs();
        }
        
        System.out.print(sb);
    }
    
    static void bfs() {
        ArrayList<Integer> result = new ArrayList<>();
        boolean isPossible = true; // 사이클 여부
        boolean isAmbiguous = false; // 순위 여러 개 가능 여부
          
        for (int i=1; i<=n; i++) {
            // 큐가 비면 사이클 발생
            if (q.isEmpty()) {
                isPossible = false;
                break;
            }
            
            // 동시에 여러 팀 가능 -> 순위 확정 불가
            if (q.size() > 1) {
                isAmbiguous = true;
            }
            
            int cur = q.poll();
            result.add(cur);

            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        if (!isPossible) {
            sb.append("IMPOSSIBLE\n");
        } else if (isAmbiguous) {
            sb.append("?\n");
        } else {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
    }
}