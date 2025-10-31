import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 약수의 개수가 홀수 -> 창문 열려있음
        // 약수의 개수가 홀수인 것은 완전제곱수

        System.out.print((int)Math.sqrt(N));
    }
}