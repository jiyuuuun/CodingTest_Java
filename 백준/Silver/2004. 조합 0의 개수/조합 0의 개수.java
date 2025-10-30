import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int fiveCount = findFive(n) - findFive(m) - findFive(n-m);
        int twoCount = findTwo(n) - findTwo(m) - findTwo(n-m);

        int answer = Math.min(fiveCount, twoCount);

        System.out.print(answer);

    }

    // x! 안에 포함된 5의 개수를 구하는 함수
    static int findFive(int x) {
        int five = 0;

        for (long p = 1; p <= x; p*=5) {
            five += x / p;
        }

        return five;
    }

    // x! 안에 포함된 2의 개수를 구하는 함수
    static int findTwo(int x) {
        int two = 0;

        for (long p = 1; p <= x; p*=2) {
            two += x / p;
        }

        return two;
    }
}