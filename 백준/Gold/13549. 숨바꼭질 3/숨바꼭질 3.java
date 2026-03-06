import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,K;
    static int[] dist = new int[100001];;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs();
        
        System.out.println(dist[K]);
        
    }
    
    // 0-1 BFS
    static void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.add(N);
        dist[N] = 0;
        
        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            
            if (x==K) return;
            
            // 순간이동(비용 0)
            int next = x*2;
            if (next<=100000 && dist[next] > dist[x]) {
                dist[next] = dist[x];
                dq.addFirst(next);
            }
            
            // x-1
            next = x-1;
            if (next>=0 && dist[next] > dist[x]+1) {
                dist[next] = dist[x]+1;
                dq.addLast(next);
            }
            
            // x+1
            next = x+1;
            if (next<=100000 && dist[next] > dist[x]+1) {
                dist[next] = dist[x]+1;
                dq.addLast(next);
            }
        }
    }
}