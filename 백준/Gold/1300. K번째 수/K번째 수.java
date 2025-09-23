import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열 크기
        int K = Integer.parseInt(br.readLine()); // K번째 수

        long left = 1;
        long right = (long) N*N;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 이하의 숫자가 몇 개인지 계산
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(answer);

    }
}