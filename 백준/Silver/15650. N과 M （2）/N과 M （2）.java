import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        visited = new boolean[N+1];
        
        dfs(0,1);
        
        System.out.println(sb);
    }
    
    static void dfs(int depth, int start) {
        // 종료 조건
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        
        for (int i=start; i<=N; i++) {
            arr[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}