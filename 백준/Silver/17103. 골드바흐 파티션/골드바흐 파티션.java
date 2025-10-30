import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        int limit = 1000000;
        boolean[] isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i*i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= limit; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int count = 0;
            int a = n / 2;
            int b = n / 2;

            while (a > 0) {
                if (isPrime[a] && isPrime[b]) {
                    count++;
                }
                a--;
                b++;
            }

            System.out.println(count);
        }
    }
}