import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l;
    static int[][] chessMap;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            l = Integer.parseInt(br.readLine()); // 체스판 길이
            chessMap = new int[l][l];
            visited = new boolean[l][l];
            dist = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()); // 현재 있는 칸
            int fy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int rx = Integer.parseInt(st.nextToken()); // 이동하려고 하는 칸
            int ry = Integer.parseInt(st.nextToken());

            int count = BFS(fx, fy, rx, ry);
            sb.append(count).append("\n");

            T--;
        }

        System.out.print(sb);
    }

    static int BFS(int fx, int fy, int rx, int ry) {
        visited[fx][fy] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{fx,fy});

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            // 목표 도착
            if (cx==rx && cy==ry) {
                return dist[cx][cy];
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx>=0 && ny>=0 && nx<l && ny<l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return 0;
    }
}