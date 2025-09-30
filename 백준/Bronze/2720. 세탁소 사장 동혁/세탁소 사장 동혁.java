import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        int[] coins = {25, 10, 5, 1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            for (int j = 0; j < coins.length; j++) {
                int count = C / coins[j];
                sb.append(count).append(" ");
                C %= coins[j];
            }

            sb.append("\n");

        }

        System.out.print(sb);
    }
}