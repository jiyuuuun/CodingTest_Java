import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 단어 수
        int M = Integer.parseInt(st.nextToken()); // 단어 길이 기준
        
        Map<String, Integer> map = new HashMap<>();
        
        while (N-- > 0) {
            String word = br.readLine();
            
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        
        Collections.sort(words, (a,b) -> {
            // 1. 빈도 내림차순
            if (map.get(a) != map.get(b)) {
                return map.get(b) - map.get(a);
            }
            // 2. 길이 내림차순
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            // 3. 사전순 오름차순
            return a.compareTo(b);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        
        System.out.println(sb);
    }
}