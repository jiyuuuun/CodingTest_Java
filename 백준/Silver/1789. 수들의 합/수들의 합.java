import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine()); // 자연수 합
        long N = 1;

        while (S != 0) {
            if (S >= N) {
                S -= N;
                N++;
            } else {
                break;
            }
        }

        System.out.print(N-1);

    }
}