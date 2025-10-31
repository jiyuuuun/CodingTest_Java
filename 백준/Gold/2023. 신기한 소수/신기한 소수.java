import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 자리수

        // 한자리 소수에서 시작
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }
    
    // 재귀 탐색 함수
    static void dfs(int num, int depth) {
        // 자릿수가 N이 되면 출력
        if (depth == N) {
            System.out.println(num);
            return;
        }

        // 뒤에 1~9 중 하나 붙이기
        for (int i = 1; i <= 9; i++) {
            int next = num*10 + i;
            if (isPrime(next)) {
                dfs(next, depth+1);
            }
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int x) {
        if (x < 2) return false;

        for (long i = 2; i*i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}