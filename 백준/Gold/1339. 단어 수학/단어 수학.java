import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] value = new int[26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int index = c - 'A'; // 인덱스 변환
                int power = (int) Math.pow(10, str.length()-j-1);
                value[index] += power; // 알파벳별 누적
            }
        }

        Arrays.sort(value); // 오름차순 정렬

        int sum = 0;
        int num = 9;
        for (int i = 25; i >= 0; i--) {
            if (value[i] != 0) {
                sum += value[i] * num;
                num--;
            }
        }

        System.out.print(sum);

    }
}