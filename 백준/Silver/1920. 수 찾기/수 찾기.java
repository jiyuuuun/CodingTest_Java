import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N];

        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(input1[i]);
        }
        Arrays.sort(n);

        int M = Integer.parseInt(br.readLine());
        int[] m = new int[M];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(input2[i]);
        }

        // 이분 탐색
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N-1;
            int find = m[i];

            while (left <= right) {
                int mid = left + (right-left) / 2;

                if (n[mid] == find) {
                    System.out.println(1);
                    break;
                } else if (n[mid] > find) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (left > right) {
                System.out.println(0);
            }
        }

    }
}