import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i=0; i<9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i,j});
                }
            }
        }
        
        dfs(0);
       
    }
    
    static void dfs(int idx) {
        // 모든 빈 칸을 다 채웠으면 출력하고 종료
        if (idx == blanks.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        int row = blanks.get(idx)[0];
        int col = blanks.get(idx)[1];
        
        for (int num = 1; num <= 9; num++) {
            if (isPossible(row, col, num)) {
                board[row][col] = num;
                dfs(idx + 1);
                board[row][col] = 0; // 백트래킹
            }
        }
    }
    
    static boolean isPossible(int row, int col, int num) {
        // 같은 행 검사
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // 같은 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 같은 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}