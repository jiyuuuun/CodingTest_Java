import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] paper;
    static int minusOne;
    static int zero;
    static int one;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 종이 크기
        
        paper = new int[N][N];
        
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        divide(0,0,N);
        
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
        
    }
    
    static void divide(int row, int col, int size) {
        int color = paper[row][col];
        boolean same = true;
        
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (paper[i][j] != color) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        
        if (same) {
            if (color == -1) minusOne++;
            else if (color == 0) zero++;
            else one++;
            return;
        }
        
        int newSize = size / 3;
        
        // 첫 번째 줄
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row, col+2*newSize, newSize);
        
        // 두 번째 줄
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
        divide(row+newSize, col+2*newSize, newSize);
        
        // 세 번째 줄
        divide(row+2*newSize, col, newSize);
        divide(row+2*newSize, col+newSize, newSize);
        divide(row+2*newSize, col+2*newSize, newSize);
    }
}