import java.util.*;
import java.io.*;

public class Main {
    static int N,W;
    static int[][] events;
    static int[][] dp;
    static int[][] choice;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도로 개수
        W = Integer.parseInt(br.readLine()); // 사건 개수
        
        events = new int[W+1][2];
        
        for (int i=1; i<=W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
        dp = new int[W+1][W+1];
        choice = new int[W+1][W+1];
        
        for (int i=0; i<=W; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // 최소 거리 출력
        System.out.println(solve(0,0));
        
        trace(0,0);
        
    }
    
    // DP 함수
    static int solve(int a, int b) {
        int next = Math.max(a,b) + 1;
        
        if (next > W) return 0;
        
        if (dp[a][b] != -1) return dp[a][b];
        
        // 경찰차1 처리
        int case1 = solve(next, b) + dist(a, next, 1);
        // 경찰차2 처리
        int case2 = solve(a, next) + dist(b, next, 2);
        
        if (case1 < case2) {
            choice[a][b] = 1;
            return dp[a][b] = case1;
        } else {
            choice[a][b] = 2;
            return dp[a][b] = case2;
        }
    }
    
    // 거리 계산
    static int dist(int from, int to, int car) {
        int x1, y1;
        
        if (from == 0) {
            if (car == 1) {
                x1 = 1;
                y1 = 1;
            } else {
                x1 = N;
                y1 = N;
            }
        } else {
            x1 = events[from][0];
            y1 = events[from][1];
        }
        
        int x2 = events[to][0];
        int y2 = events[to][1];
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    // 경로 추적
    static void trace(int a, int b) {
        if (Math.max(a, b) == W) return;
        
        int next = Math.max(a, b) + 1;
        
        if (choice[a][b] == 1) {
            System.out.println(1);
            trace(next, b);
        } else {
            System.out.println(2);
            trace(a, next);
        }
    }
}