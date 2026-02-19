import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] video;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 영상 크기
        
        video = new int[N][N];
        sb = new StringBuilder();
        
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                video[i][j] = s.charAt(j)-'0';
            }
        }
        
        divide(0,0,N);
        
        System.out.println(sb);
    }
    
    static void divide(int row, int col, int size) {
        int color = video[row][col];
        boolean same = true;
        
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (color != video[i][j]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        
        if (same) {
            sb.append(color);
            return;
        }
        
        int newSize = size / 2;
        sb.append("(");
        
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
        
        sb.append(")");
    }
}