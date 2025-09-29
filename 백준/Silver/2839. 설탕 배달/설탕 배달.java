import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 설탕
        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += (N / 5);
                N %= 5;
                break;
            } else {
                N -= 3;
                count++;

                if (N < 0) {
                    System.out.print(-1);
                    break;
                }
            }
        }

        if (N == 0) {
            System.out.print(count);
        }
    }
}