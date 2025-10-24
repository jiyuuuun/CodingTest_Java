import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int limit = 123456 * 2;
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
        
        // 입력 받기
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime[i]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}