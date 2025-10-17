import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 거스름돈 액수

        int coin = 0;

        // 5원을 최대로 쓰면서, 남은 금액이 2로 나누어떨어질 때까지 반복
        while (n >= 0) {
            if (n % 5 == 0) {
                coin += n / 5; // 5로 나눠떨어지면 끝
                System.out.print(coin);
                return;
            } else {
                // 아니면 2원으로 처리
                n -= 2;
                coin++;
            }
        }

        System.out.print(-1);

    }
}