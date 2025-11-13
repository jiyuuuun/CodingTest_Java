import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.print(BFS(0,0));

    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0}); // x, y, 벽 부쉈는지 여부(0=안 부숨, 1=부숨)
        dist[x][y][0] = 1; // 시작 지점 거리 = 1

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int broken = cur[2]; // 벽 부쉈는지 여부

            // 도착하면 거리 반환
            if (cx == N-1 && cy == M-1) {
                return dist[cx][cy][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;

                // 이동할 곳이 벽이 아니고 아직 방문 안했을 때
                if (map[nx][ny]==0 && dist[nx][ny][broken]==0) {
                    dist[nx][ny][broken] = dist[cx][cy][broken] + 1;
                    q.add(new int[]{nx,ny,broken});
                }

                // 이동할 곳이 벽인데 아직 안 부순 상태일 때
                if (map[nx][ny]==1 && broken==0 && dist[nx][ny][1]==0) {
                    dist[nx][ny][1] = dist[cx][cy][broken] + 1;
                    q.add(new int[]{nx,ny,1});
                }
            }
        }
        return -1;
    }
}