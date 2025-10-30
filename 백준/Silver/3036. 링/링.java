import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 링 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken()); // 8

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            
            int gcd = findGCD(first, next);
            
            System.out.println((first / gcd) + "/" + (next/gcd));
        }
    }

    static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}