import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[3];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int x : A) {
            sb.append(x).append(" ");
        }

        System.out.print(sb);
    }
}