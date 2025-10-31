import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());

            while (true) {
                if (isPrime(n)) {
                    System.out.println(n);
                    break;
                } else {
                    n++;
                }
            }
        }
    }

    // 소수 확인
    static boolean isPrime(long x) {
        if (x < 2 ) return false;

        for (long i = 2; i*i <= x; i++) {
            if (x % i == 0) return false; // 나누어떨어지면 소수가 아님
        }

        return true;
    }
}