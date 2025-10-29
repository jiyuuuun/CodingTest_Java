import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input[j+1]);
            }

            long sum = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    sum += findGCD(arr[j] , arr[k]);
                }
            }

            System.out.println(sum);
        }
    }

    // 최대공약수
    static int findGCD(int x, int y) {
        while (y > 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}