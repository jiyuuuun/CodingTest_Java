import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 가로수 개수

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 간격 구하기
        int[] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        // 모든 간격의 최대공약수 구하기
        int gcd = diff[0];
        for (int i = 1; i < diff.length; i++) {
            gcd = findGCD(gcd, diff[i]);
        }

        // 필요한 나무의 수 계산
        int answer = 0;
        for (int d : diff) {
            answer += (d / gcd) - 1;
        }

        System.out.print(answer);
    }

    // 최대공약수 구하기
    static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}