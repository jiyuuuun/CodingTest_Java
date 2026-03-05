import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,E;
    static ArrayList<int[]>[] graph; // 인접 리스트 (도착 정점, 가중치)
    
    // 다익스트라
    static int[] dijkstra(int start) {
        int dist[] = new int[N+1]; // 최단 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{start,0});
        
        while (!pq.isEmpty()) {
            
            int[] cur = pq.poll();
            int now = cur[0]; // 현재 정점
            int cost = cur[1]; // 현재 정점까지의 거리
            
            // 이미 더 짧은 경로가 있으면 무시
            if (cost > dist[now]) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (dist[nextNode] > dist[now] + nextCost) {
                    dist[nextNode] = dist[now] + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 수
        E = Integer.parseInt(st.nextToken()); // 간선 수
        
        // 그래프 초기화
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c}); // 무방향
        }
        
        // 반드시 지나야 하는 두 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        // 각 시작점에서의 최단 거리 계산
        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);
        
        // 가능한 두 경로
        int path1 = Integer.MAX_VALUE;
        if(dist1[v1] != Integer.MAX_VALUE &&
           distV1[v2] != Integer.MAX_VALUE &&
           distV2[N] != Integer.MAX_VALUE)
            path1 = dist1[v1] + distV1[v2] + distV2[N]; // 1. 1 -> v1 -> v2 -> N
        int path2 = Integer.MAX_VALUE;
        if(dist1[v2] != Integer.MAX_VALUE &&
           distV2[v1] != Integer.MAX_VALUE &&
           distV1[N] != Integer.MAX_VALUE)
            path2 = dist1[v2] + distV2[v1] + distV1[N]; // 2. 1 -> v2 -> v1 -> N
        
        int answer = Math.min(path1, path2);
        
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}