import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // HashSet 사용
        HashSet<Integer> set = new HashSet<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        int M = Integer.parseInt(br.readLine());

        String[] con = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(con[i]))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}