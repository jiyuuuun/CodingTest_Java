import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N,K;
    static int[][][] tomatoBox;
    
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        K = Integer.parseInt(st.nextToken()); // 높이

        tomatoBox = new int[K][N][M];
        Queue<int[]> q = new LinkedList<>();

        // 토마토 상자 입력
        for (int k = 0; k < K; k++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatoBox[k][n][m] = Integer.parseInt(st.nextToken());
                    if (tomatoBox[k][n][m] == 1) {
                        q.add(new int[] {k,n,m}); // 익은 토마토 위치
                    }
                }
            }
        }

        int days = bfs(q);
        System.out.println(days);

    }

    static int bfs (Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz>=0 && nx>=0 && ny>=0 && nz<K && nx<N && ny<M) {
                    if (tomatoBox[nz][nx][ny] == 0) { // 익지 않은 토마토
                        tomatoBox[nz][nx][ny] = tomatoBox[z][x][y] + 1; // 날짜 + 1
                        q.add(new int[] {nz,nx,ny});
                    }
                }
            }
        }

        int max = 0;
        for (int k = 0; k < K; k++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoBox[k][n][m] == 0 ) return -1; // 안 익은 토마토 존재
                    max = Math.max(max, tomatoBox[k][n][m]);
                }
            }
        }

        return max-1;
    }
}