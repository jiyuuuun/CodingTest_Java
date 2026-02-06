import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] col;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        col = new int[N];
        
        dfs(0);
        
        System.out.println(count);
    }
    
    static void dfs(int row) {
        // 종료 조건: 모든 행에 퀸을 놓음
        if (row == N) {
            count++;
            return;
        }
        
        // 현재 row에서 열 하나씩 시도
        for (int c=0; c<N; c++) {
            col[row] = c;
            
            if (isPossible(row)) {
                dfs(row+1);
            }
        }
    }
    
    static boolean isPossible(int row) {
        for (int i=0; i<row; i++) {
            // 같은 열
            if (col[i] == col[row]) return false;
            
            // 같은 대각선
            if (Math.abs(row-i) == Math.abs(col[row]-col[i])) {
                return false;
            }
        }
        return true;
    }
}