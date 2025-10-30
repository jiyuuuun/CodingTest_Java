import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min + 1);
        boolean[] isPow = new boolean[size];

        for (long i = 2; i*i <= max; i++) {
            // min 이상에서 i*i의 첫 배수 계산
            long start = (min / (i*i)) * (i*i);
            if (start < min) start += i*i;

            // start부터 max까지 i*i 단위로 배수 표시
            for (long j = start; j <= max; j += i*i) {
                isPow[(int)(j-min)] = true;
            }
        }

        // 제곱수가 아닌 수
        int count = 0;
        for (boolean b : isPow) {
            if (!b) count++;
        }

        System.out.print(count);
    }
}