import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean found = false;

            // 두 소수의 합으로 표현 찾기
            for (int i = 2; i <= n/2 ; i++) {
                if (isPrime[i] && isPrime[n-i]) {
                    System.out.println(n + " = " + i + " + " + (n-i));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

}
