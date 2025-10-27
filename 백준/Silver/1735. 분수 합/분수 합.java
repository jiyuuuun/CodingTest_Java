import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 분수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstN = Integer.parseInt(st.nextToken()); // 분자
        int firstD = Integer.parseInt(st.nextToken()); // 분모

        // 두번째 분수 입력
        st = new StringTokenizer(br.readLine());
        int secondN = Integer.parseInt(st.nextToken()); // 분자
        int secondD = Integer.parseInt(st.nextToken()); // 분모

        // 최소공배수 계산
        int lmc = findLCM(firstD, secondD);

        // 분수 더하기
        int numerator = firstN * (lmc / firstD) + secondN * (lmc / secondD);

        // 최대공약수로 기약분수 만들기
        int gcd = findGCD(numerator, lmc);
        numerator /= gcd;
        lmc /= gcd;

        System.out.print(numerator + " " + lmc);
    }

    // 최대공약수 계산
    static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    // 최소공배수 계산
    static int findLCM(int x, int y) {
        return x * y / findGCD(x,y);
    }
}