import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
        int[] waterPos = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            waterPos[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(waterPos); // 오름차순 정렬

        int count = 0; // 테이프의 개수
        int i = 0;
        while (i < N) {
            count++;
            double coverEnd = (double) waterPos[i] - 0.5 + L;

            i++;
            while (i < N && (double) waterPos[i] <= coverEnd) {
                i++;
            }
        }

        System.out.print(count);
    }
}