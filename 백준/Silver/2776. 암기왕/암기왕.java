import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] book1 = new int[N];

            String[] input1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                book1[j] = Integer.parseInt(input1[j]);
            }

            // 정렬
            Arrays.sort(book1); // 1 2 3 4 5

            int M = Integer.parseInt(br.readLine());
            String[] input2 = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(input2[j]);
                int left = 0;
                int right = N-1;

                boolean found = false;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (num > book1[mid]) {
                        left = mid + 1;
                    } else if (num < book1[mid]) {
                        right = mid - 1;
                    } else {
                        found = true;
                        break;
                    }
                }

                if (found) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}