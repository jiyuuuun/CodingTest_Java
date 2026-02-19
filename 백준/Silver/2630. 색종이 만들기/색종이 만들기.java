import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] paper;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 종이 한 변의 길이
        
        paper = new int[N][N];
        
        // 종이 입력
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        divide(0, 0, N); // 전체 종이부터 검사 시작
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    static void divide(int row, int col, int size) {
        int color = paper[row][col]; // 첫 칸 색 저장
        boolean same = true; // 모두 같은 색인지 확인
        
        // 현재 영역이 모두 같은 색인지 검사
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (paper[i][j] != color) { // 다른 색 발견
                    same = false;
                    break;
                }
            }
            if (!same) break; // 이미 다르면 반복 중단
        }
        
        // 모두 같은 색이면 카운트 증가
        if (same) {
            if (color == 0) white++;
            else blue++;
            return;
        }
        
        // 색이 섞여 있으면 4등분
        int newSize = size / 2;
        
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
    }
}