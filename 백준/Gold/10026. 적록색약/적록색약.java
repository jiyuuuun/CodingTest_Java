import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static char[][] temp;
    static boolean[][] visited;
    static int count1, count2;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 크기

        map = new char[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 일반인 구역 세기
        visited = new boolean[N][N];
        count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(map,i,j);
                    count1++;
                }
            }
        }

        // 적록색맹 지도 만들기
        temp = new char[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone(); // 맵 복사
            for (int j = 0; j < N; j++) {
                if (temp[i][j] == 'G') temp[i][j] = 'R';
            }
        }

        // 적록색맹 구역 세기
        visited = new boolean[N][N];
        count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(temp,i,j);
                    count2++;
                }
            }
        }

        System.out.print(count1 + " " + count2);

    }

    static void dfs(char[][] currentMap,int x, int y) {
        visited[x][y] = true;
        char color = currentMap[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && ny>=0 && nx<N && ny<N) {
                if (!visited[nx][ny] && currentMap[nx][ny] == color) {
                    dfs(currentMap,nx,ny);
                }
            }
        }
    }
}