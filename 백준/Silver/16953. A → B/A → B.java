import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1;

        while (A < B) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            answer++;
        }

        if (A == B) {
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }
}