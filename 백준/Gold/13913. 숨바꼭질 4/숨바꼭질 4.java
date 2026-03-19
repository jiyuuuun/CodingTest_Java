import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] prev = new int[100001]; // prev[i] = i에 오기 직전 위치
    static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        
        bfs();
        
    }
    
    static void bfs() {
        Queue<Integer> q =new LinkedList<>();
        q.add(N);
        visited[N] = true;
        prev[N] = -1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == K) {
                printPath(cur);
                return;
            }
            
            int[] nexts = {cur-1, cur+1, cur*2};
            
            for (int next : nexts) {
                if (next>=0 && next<=100000 && !visited[next]) {
                    visited[next] = true;
                    prev[next] = cur;
                    q.add(next);
                }
            }
        }
    }
    
    static void printPath(int cur) {
        ArrayList<Integer> path = new ArrayList<>();
        
        while (cur != -1) {
            path.add(cur);
            cur = prev[cur];
        }
        
        Collections.reverse(path);
        
        System.out.println(path.size() - 1);
        
        for (int x : path) {
            System.out.print(x + " ");
        }
    }
}