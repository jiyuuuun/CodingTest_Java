import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,w}); // [도착정점, 가중치]
        }

        // 다익스트라
        int[] dist = new int[V+1]; // 최단 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{K,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

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

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}