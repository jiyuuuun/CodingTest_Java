import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> {
            if (a.getValue().equals(b.getValue())) {
                return Long.compare(a.getKey(), b.getKey()); // 빈도 같으면 숫자 작은 순
            } else {
                return Integer.compare(b.getValue(), a.getValue()); // 빈도 큰 순
            }
        });

        System.out.print(list.get(0).getKey());

    }
}