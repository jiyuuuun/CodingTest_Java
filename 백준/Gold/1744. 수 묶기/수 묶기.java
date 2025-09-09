import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> positives = new ArrayList<>(); // 1보다 큰 양수
        List<Integer> negatives = new ArrayList<>(); // 음수

        int ones = 0; // 1의 개수
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) positives.add(num);
            else if (num == 1) ones++;
            else if (num == 0) hasZero = true;
            else negatives.add(num);
        }

        // 양수는 내림차순 정렬
        Collections.sort(positives, Collections.reverseOrder());
        // 음수는 오름차순 정렬
        Collections.sort(negatives);

        long sum = 0;

        // 양수는 두개씩 묶기
        for (int i = 0; i < positives.size(); i+=2) {
            if (i+1 < positives.size()) {
                sum += positives.get(i) * positives.get(i+1);
            } else {
                sum += positives.get(i);
            }
        }

        // 음수도 두개씩 묶기
        for (int i = 0; i < negatives.size(); i+=2) {
            if (i+1 < negatives.size()) {
                sum += negatives.get(i) * negatives.get(i+1);
            } else {
                if (!hasZero) sum += negatives.get(i); // 0없으면 그냥 더함
                // 0 있으면 음수 버려짐
            }
        }

        // 1은 무조건 더하기
        sum += ones;

        System.out.print(sum);
    }
}