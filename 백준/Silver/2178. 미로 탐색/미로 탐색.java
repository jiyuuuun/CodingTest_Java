import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.print(bfs(0,0));
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 체크 + 길 체크 + 방문 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[cx][cy] +1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return maze[N-1][M-1]; // 도착지점 값 = 최단거리
    }
}