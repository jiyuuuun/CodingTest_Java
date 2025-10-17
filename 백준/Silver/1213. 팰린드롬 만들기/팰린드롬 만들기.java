import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();

        String input = br.readLine();

        // 문자 개수 세기
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        char oddChar = 0;

        // 홀수 개수 문자 확인
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount++;
                oddChar = entry.getKey();
            }
        }

        if (2 <= oddCount) {
            System.out.print("I'm Sorry Hansoo");
            return;
        } else {
            // 정렬된 키 리스트
            List<Character> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);

            // 앞부분
            StringBuilder left = new StringBuilder();
            for (char key : keys) {
                int count = map.get(key) / 2;
                for (int i = 0; i < count; i++) {
                    left.append(key);
                }
            }

            // 가운데 문자
            String mid = "";
            if (oddCount == 1) {
                mid = String.valueOf(oddChar);
            }

            // 오른쪽
            String right = new StringBuilder(left).reverse().toString();

            System.out.print(String.valueOf(left) + mid + right);
        }
    }
}
