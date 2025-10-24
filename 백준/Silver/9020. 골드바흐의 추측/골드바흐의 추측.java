import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        int limit = 10000;
        boolean[] isPrime = new boolean[limit+1];

        // 소수 배열 초기화
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for (int i = 2; i*i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <=limit ; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // n의 절반에서 시작해서 점점 멀어지며 검사
            int a = n / 2;
            int b = n / 2;

            while (a > 0) {
                if (isPrime[a] && isPrime[b]) { // 두 수가 모두 소수라면
                    sb.append(a).append(" ").append(b).append("\n");
                    break;
                }
                a--;
                b++;
            }
        }

        System.out.print(sb);
    }
}