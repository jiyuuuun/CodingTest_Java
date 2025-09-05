import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a,b) -> a[0] - b[0]);

            int count = 1; // 첫 번째 사람은 무조건 선발
            int min = arr[0][1];

            for (int i = 0; i < N; i++) {
                if (arr[i][1] < min) { // 면접 순위 비교
                    count++;
                    min = arr[i][1];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}