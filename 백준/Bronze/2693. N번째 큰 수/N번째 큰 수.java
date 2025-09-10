import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            int[] test = new int[10];

            for (int j = 0; j < 10; j++) {
                test[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(test);
            sb.append(test[7]).append("\n");
        }

        System.out.print(sb);
    }
}