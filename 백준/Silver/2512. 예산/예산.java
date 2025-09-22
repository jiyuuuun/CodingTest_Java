import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지방 수
        int[] city = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 총 예산

        int left = 0;
        int right = Arrays.stream(city).max().getAsInt();
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 상한선 후보
            long sum = 0;

            // 각 지방에 mid 상한선 적용
            for (int i = 0; i < N; i++) {
                sum += Math.min(city[i], mid);
            }

            // 총합이 M 이하이면 상한선 올릴 수 있음
            if (sum <= M) {
                result = mid;
                left = mid + 1; // 높이기
            } else {
                right = mid - 1; // 낮추기
            }
        }

        System.out.print(result);

    }
}