import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        
        // 처음엔 전부 공백
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = ' ';
            }
        }
        
        star(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void star(int x, int y, int size) {
        if (size == 1) {
            map[x][y] = '*';
            return;
        }
        
        int next = size/3;
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                
                // 가운데 칸이면 공백
                if (i==1 && j==1) {
                    for (int a=x+next; a<x+2*next; a++) {
                        for (int b=y+next; b<y+2*next; b++) {
                            map[a][b] = ' ';
                        }
                    }
                }
                // 나머지 8칸은 재귀
                else {
                    star(x+i*next, y+j*next, next);
                }
            }
        }
    }
}