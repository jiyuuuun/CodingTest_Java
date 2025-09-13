import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 용액의 수

        long[] arr = new long[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr); // 정렬

        long bestAbs = Long.MAX_VALUE;
        long a=0, b=0, c=0;

        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < bestAbs) {
                    bestAbs = Math.abs(sum);
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // sum == 0 -> 최적이므로 바로 죵료
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    return;
                }
            }
        }

        System.out.println(a + " " + b + " " + c);
    }
}