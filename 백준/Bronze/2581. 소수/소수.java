import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }

            if (count == 2) list.add(i); // 소수면 리스트에 추가
        }

        // 소수가 없는 경우
        if (list.isEmpty()) {
            System.out.print(-1);
            return;
        }
        
        int min = list.get(0);
        int sum = 0;

        for (int i:list) {
            sum += i;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n").append(min);

        System.out.print(sb);

    }
}