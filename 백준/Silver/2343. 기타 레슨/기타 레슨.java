import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0; // 가장 긴 강의 시간
        int right = 0; // 전체 합

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1; // 블루레이 개수
            int sum = 0; // 현재 블루레이에 담긴 시간 합

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) { // 현제 블루레이에 못 담으면
                    cnt++; // 새로운 블루레이 필요
                    sum = 0;
                }
                sum += arr[i];
            }

            if (cnt <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(answer);

    }
}