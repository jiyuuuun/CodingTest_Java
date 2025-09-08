import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N =br.readLine();
        char[] digits = N.toCharArray();

        boolean hasZero = false;
        int sum = 0;
        for (char c : digits) {
            if (c == '0') hasZero = true;
            sum += c - '0';
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.print(-1);
            return;
        }

        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.print(sb.reverse());

    }
}