import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static ArrayList<int[]>[] graph;
    
    // 다익스트라: start에서 모든 노드까지 최단거리
    static int[] dijkstra(int start) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{start,0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            
            // 이미 더 짧은 경로가 있으면 스킵
            if (cost>dist[now]) continue;
            
            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                // 더 짧은 경로 발견 시 갱신
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
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        while (T-- > 0) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 교차로 개수
            int m = Integer.parseInt(st.nextToken()); // 도로 개수
            int t = Integer.parseInt(st.nextToken()); // 목적지 개수
            
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 예술가 출발지
            int g = Integer.parseInt(st.nextToken()); 
            int h = Integer.parseInt(st.nextToken()); 
            
            // 그래프 초기화
            graph = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            int ghDist = 0; // g-h 도로 거리
            
            // 도로 정보 입력
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                
                graph[a].add(new int[]{b,d});
                graph[b].add(new int[]{a,d});
                
                // g-h 도로 거리 저장
                if ((a==g && b==h) || (a==h && b==g)) {
                    ghDist = d;
                }
            }
            
            // s, g, h 기준 최단거리 계산
            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);
            
            // 목적지 후보 저장
            ArrayList<Integer> candidate = new ArrayList<>();
            
            while (t-- > 0) {
                candidate.add(Integer.parseInt(br.readLine())); // 목적지 후보들
            }
            
            Collections.sort(candidate); // 오름차순 출력
            
            StringBuilder sb = new StringBuilder();
            
            for (int x : candidate) {
                int path1 = distS[g] + ghDist + distH[x]; // s → g → h → x 경로
                int path2 = distS[h] + ghDist + distG[x]; // s → h → g → x 경로
                
                // g-h를 지나가는 최단경로라면 출력
                if (distS[x] == path1 || distS[x] == path2) {
                    sb.append(x).append(" ");
                }
            }
            
            System.out.println(sb);
        
        }
    }
}