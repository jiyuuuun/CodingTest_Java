import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[100001];

        q.add(new int[] {N,0}); // 위치, 시간
        visited[N] = true;

        // BFS
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int time = now[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            // 이동 3가지
            int[] nextPos = {pos-1, pos+1, pos*2};

            for (int next : nextPos) {
                if (next>=0 && next<= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, time+1});
                }
            }
        }
    }
}