import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int maxHeight = 0;
    static int maxSection = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int section = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j]>h && !visited[i][j]) {
                        BFS(i,j,h);
                        section++;
                    }
                }
            }
            maxSection = Math.max(maxSection, section);
        }

        System.out.print(maxSection);
    }

    static void BFS(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx>=0 && ny>=0 && nx<N && ny<N) {
                    if (!visited[nx][ny] && map[nx][ny]>h) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}