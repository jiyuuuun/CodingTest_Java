import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] board = new int[101];
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 사다리 개수
        int M = Integer.parseInt(st.nextToken()); // 뱀 개수
        
        // 사다리 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            board[x] = y; // x번 칸에 도착하면 y번으로 이동
        }
        
        // 뱀 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            board[u] = v; // u번 칸에 도착하면 v번으로 이동
        }
        
        bfs(1); // 1번 칸에서 시작
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll(); // 현재 위치
            
            // 주사위 1~6까지 모든 경우 탐색
            for (int dice=1; dice<=6; dice++) {
                int next = cur + dice;
                
                if (next > 100) continue; // 100번 초과는 무시
                
                // 사다리 또는 뱀이 있다면 해당 위치로 이동
                if (board[next] != 0) {
                    next = board[next];
                }
                
                // 아직 방문하지 않은 칸이라면
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
                
                // 100번 칸 도착 시 최소 횟수 출력 후 종료
                if (next == 100) {
                    System.out.println(dist[next]);
                    return;
                }
            }
        }
    }
}