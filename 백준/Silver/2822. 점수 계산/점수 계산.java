import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> scoresMap = new HashMap<>();

        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine());
            scoresMap.put(i, score);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(scoresMap.entrySet());

        Collections.sort(list, (a, b) -> {
            return b.getValue() - a.getValue();
        });

        int sum = 0;
        int[] topFive = new int[5];

        for (int i = 0; i < 5; i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            sum += entry.getValue();
            topFive[i] = entry.getKey();
        }

        Arrays.sort(topFive);

        StringBuilder sb = new StringBuilder();
        for (int i : topFive) {
            sb.append(i).append(" ");
        }

        System.out.println(sum);
        System.out.print(sb);
    }
}