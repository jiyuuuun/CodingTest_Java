import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 수
        int M = Integer.parseInt(st.nextToken()); // 원하는 나무 길이

        long[] trees = new long[N];
        String[] input = br.readLine().split(" ");
        long maxHeight = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(input[i]);
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        long left = 0;
        long right = maxHeight;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }

            if (sum >= M) {
                result = mid; // 가능하면 최대값 저장
                left = mid + 1; // 더 높여서 시도
            } else {
                right = mid - 1; // 너무 많이 잘림 -> 낮춰야 함
            }
        }

        System.out.print(result);
    }
}