import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int limit = 4000000;
        boolean[] isPrime = new boolean[limit+1];

        // 소수 배열 초기화
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for (int i = 2; i*i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= limit; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 리스트 생성
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        // 두 포인터로 연속합 구하기
        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(left++);
            } else if (right == primes.size()) {
                break; // 오른쪽 끝까지 탐색하면 종료
            } else {
                sum += primes.get(right++);
            }

            if (sum == N) count++;
        }

        System.out.print(count);

    }
}