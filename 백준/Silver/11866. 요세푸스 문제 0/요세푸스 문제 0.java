import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int current = 1;

        while (q.size() > 0) {
            if (current % K == 0) {
                sb.append(q.poll());
                if (q.size() != 0) {
                    sb.append(", ");
                }
            } else {
                q.add(q.poll());
            }
            current++;
        }

        sb.append(">");

        System.out.println(sb);
    }
}