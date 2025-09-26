import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to; // 연결된 섬 번호
        int weight; // 다리 최대 중량

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N,M,start,end;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 섬 개수
        M = Integer.parseInt(st.nextToken()); // 다리 개수

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxWeight = 0;

        // 다리 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 섬 a
            int b = Integer.parseInt(st.nextToken()); // 섬 b
            int w = Integer.parseInt(st.nextToken()); // 다리 중량

            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w)); // 양방향

            if (maxWeight < w) {
                maxWeight = w;
            }
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = maxWeight;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[N+1];
            if (canMoveDFS(start, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }

    // DFS
    static boolean canMoveDFS(int current, int weight) {
        if (current == end) return true;
        visited[current] = true;

        for (Edge e : graph[current]) {
            if (!visited[e.to] && e.weight >= weight) {
                if (canMoveDFS(e.to, weight)) return true;
            }
        }
        return false;
    }
}