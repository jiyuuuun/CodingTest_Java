import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    if (sb.length() > 0) sb.append(" + ");
                    sb.append(i);
                }
            }

            if (n == sum) answer.append(n + " = " + sb).append("\n");
            else answer.append(n + " is NOT perfect.").append("\n");
        }

        System.out.print(answer);
    }
}