import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] sorted = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
            sorted[i] = A[i];
        }

        Arrays.sort(sorted);

        // 중복 제거 후 Map에 값 -> 압축된 좌표 저장
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }
        
        // 원래 배열 순서대로 출력
        StringBuilder sb = new StringBuilder();
        for (int x : A) {
            sb.append(map.get(x)).append(" ");
        }

        System.out.print(sb);
    }
}