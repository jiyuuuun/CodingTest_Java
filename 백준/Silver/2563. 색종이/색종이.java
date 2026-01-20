import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 색종이의 수
        
        // 100x100 도화지 (0:안 칠해짐, 1: 칠해짐)
        int[][] paper = new int[100][100];
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            
            for (int i=left; i<left+10; i++) {
                for (int j=bottom; j<bottom+10; j++) {
                    paper[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        
        // 전체 도화지에서 칠해진 칸의 개수 세기
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (paper[i][j] == 1) {
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
}