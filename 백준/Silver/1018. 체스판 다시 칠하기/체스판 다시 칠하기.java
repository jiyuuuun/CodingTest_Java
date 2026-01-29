import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        
        for (int i=0; i<N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                
                int cntW = 0; // (i,j)를 W로 시작한다고 가정했을 때 다시 칠해야 하는 칸 수
                int cntB = 0; // (i,j)를 B로 시작한다고 가정했을 때 다시 칠해야 하는 칸 수
                
                for (int x=i; x<i+8; x++) {
                    for (int y=j; y<j+8; y++) {
                        
                        // (x + y)가 짝수인 칸 → 시작 색과 같아야 함
                        if ((x+y) % 2 == 0) {
                            if (board[x][y] != 'W') cntW++; // W로 시작했을 때: 이 칸은 W여야 함
                            if (board[x][y] != 'B') cntB++; // B로 시작했을 때: 이 칸은 B여야 함
                        } 
                        // (x + y)가 홀수인 칸 → 시작 색과 반대 색이어야 함 
                        else { 
                            if (board[x][y] != 'B') cntW++; // W로 시작했을 때: 이 칸은 B여야 함
                            if (board[x][y] != 'W') cntB++; // B로 시작했을 때: 이 칸은 W여야 함
                        }
                    }
                }
                
                // W로 시작 vs B로 시작 중 더 적게 칠하는 경우 선택
                answer = Math.min(answer, Math.min(cntW, cntB));
            }
        }
        
        System.out.println(answer);
    }
}