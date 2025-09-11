import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i: list) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}