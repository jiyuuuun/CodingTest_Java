import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 단어 길이 기준

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) +1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> {
            // 1. 자주 나오는 단어일수록 앞에 (빈도 내림차순)
            if (!a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getValue(), a.getValue());
            }
            // 2. 단어 길이가 길수록 앞에
            if (a.getKey().length() != b.getKey().length()) {
                return Integer.compare(b.getKey().length(), a.getKey().length());
            }
            // 3. 알파벳 사전 순
            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }

        System.out.print(sb);
    }
}