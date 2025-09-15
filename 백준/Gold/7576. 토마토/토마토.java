import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] tomatoBox;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        tomatoBox = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        // 토마토 상태 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(input[j]);
                if (tomatoBox[i][j] == 1) { // 익은 토마토라면 시작점
                    q.add(new int[]{i,j});
                }
            }
        }

        // BFS 시작
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (tomatoBox[nx][ny] == 0) { // 안 익은 토마토
                        tomatoBox[nx][ny] = tomatoBox[x][y] + 1; // 날짜 기록
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

        int days = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 0) { // 안 익은 토마토 발견
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, tomatoBox[i][j]);
            }
        }

        System.out.println(days-1); // 처음 시작이 1이니까 -1 해줌
    }
}