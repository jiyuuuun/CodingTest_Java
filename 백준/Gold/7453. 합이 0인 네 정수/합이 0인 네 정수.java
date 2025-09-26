import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 배열 크기

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int left = 0;
        int right = n*n - 1;

        while (left < n*n && right >= 0) {
            long sum = (long) AB[left] + (long) CD[right];

            if (sum == 0) {
                long countLeft = 1;
                long countRight = 1;
                int l = left + 1;
                int r = right - 1;

                // AB[left]와 같으 값 개수 세기
                while (l < n*n && AB[l] == AB[left]) {
                    countLeft++;
                    l++;
                }

                // CD[right]와 같은 값 개수 세기
                while (r >= 0 && CD[r] == CD[right]) {
                    countRight++;
                    r--;
                }

                answer += countLeft * countRight;
                left = l;
                right = r;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(answer);
    }
}