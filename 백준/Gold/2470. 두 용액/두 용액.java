import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // 용액의 특성값
        int[] A = new int[N];

        String[] input = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(A);

        int left = 0;
        int right = N-1;
        int ansLeft = A[left];
        int ansRight = A[right];
        long minSum = Math.abs((long)A[left] + A[right]);

        while (left < right) {
            long sum = (long)A[left] + A[right];

            if(Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ansLeft = A[left];
                ansRight = A[right];
            }

            if(sum > 0) {
                right--; // 합이 크니까 줄이기
            } else {
                left++; // 합이 작으니까 키우기
            }
        }

        System.out.print(ansLeft + " " + ansRight);
    }
}