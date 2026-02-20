import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N; // 수의 개수
    static int[][] team;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        
        team = new int[N][N];
        visited = new boolean[N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.println(min);
        
    }
    
    // depth: 현재 팀에 뽑은 인원 수
    // start: 다음 탐색 시작 인덱스
    static void dfs(int depth, int start) {
        // N/2 명을 다 뽑았다면
        if (depth == N/2) {
            calculate();
            return;
        }
        
        for (int i=start; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false; // 복구
            }
        }
    }
    
    // 두 팀 능력치 차이 계산
    static void calculate() {
        int teamStart = 0;
        int teamLink = 0;
        
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += team[i][j] + team[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += team[i][j] + team[j][i];
                }
            }
        }
        
        min = Math.min(min, Math.abs(teamStart - teamLink));
    }
}