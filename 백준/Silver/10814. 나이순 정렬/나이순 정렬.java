import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(input);
        }

        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        StringBuilder sb = new StringBuilder();
        for(String[] member : list) {
            sb.append(member[0]).append(" ").append(member[1]).append("\n");
        }

        System.out.print(sb);
    }
}