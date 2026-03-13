import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] weight;
    static boolean[][] visited;
    static boolean[] possible;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 추 개수
        
        weight = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        
        // 최대 무게 차이  = 30 * 500 = 15000
        visited = new boolean[N+1][15001];
        possible = new boolean[15001];
        
        dfs(0,0); //dfs 시작 (0번째 추, 현재 무게차 0)
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<M; i++) {
            int marble = Integer.parseInt(st.nextToken());
            
            // 만들 수 있는 무게면 Y
            if (marble <= 15000 && possible[marble]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        
        System.out.println(sb);
    }
    
    static void dfs(int idx, int diff) {
        // 이미 방문한 상태면 종료 (중복 탐색 방지)
        if (visited[idx][diff]) return;
        
        visited[idx][diff] = true;
        
        // 이 무게 차이는 만들 수 있음
        possible[diff] = true;
        
        // 모든 추를 다 사용했으면 종료
        if (idx==N) return;
        
        int w = weight[idx];
        
        // 1. 추를 사용하지 않음
        dfs(idx+1, diff);
        // 2. 같은 쪽에 올림 -> 무게 차이 증가
        dfs(idx+1, diff+w);
        // 3. 반대쪽에 올림 -> 무게 차이 감소
        dfs(idx+1, Math.abs(diff-w));
        
    }
}