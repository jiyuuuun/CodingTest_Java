import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] A;
    static boolean[][] visited;
    static int count;
    static int N;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexList = new ArrayList<>();
        int complexCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j]==1 && !visited[i][j]) {
                    count = 0;
                    DFS(i,j);
                    complexList.add(count);
                    complexCount++;
                }
            }
        }
        System.out.println(complexCount);
        Collections.sort(complexList);
        for (int house: complexList) {
            System.out.println(house);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && ny>=0 && nx<N && ny<N) {
                if (A[nx][ny]==1 & !visited[nx][ny])
                    DFS(nx,ny);
            }
        }
    }
}
