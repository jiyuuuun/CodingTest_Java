import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] temp;
    static int maxSafe = 0;

    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기

        map = new int[N][M];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 벽 세우기 시작
        buildWall(0);

        System.out.println(maxSafe);
    }

    // 벽 3개 세우기
    public static void buildWall(int count) {
        if (count == 3) {
            superVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빈 칸이면 벽 세우기
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 세움
                    buildWall(count + 1);
                    map[i][j] = 0; // 원상복구
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static void superVirus() {
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone(); // 맵 복사
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) {
                    q.add(new int[] {i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }
        countSafe();
    }

    // 안전 영역 계산
    static void countSafe() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safe++;
                }
            }
        }
        maxSafe = Math.max(maxSafe, safe);
    }
}