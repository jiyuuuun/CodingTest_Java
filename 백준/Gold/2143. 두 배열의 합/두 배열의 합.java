import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Integer.parseInt(br.readLine()); // 합

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(input2[i]);
        }

        // A 부분합
        ArrayList<Long> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        // B 부분합
        ArrayList<Long> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        // sumB를 HashMap에 등장 횟수 저장
        HashMap<Long, Integer> mapB = new HashMap<>();
        for (long num : sumB) {
            mapB.put(num, mapB.getOrDefault(num, 0) + 1);
        }

        long answer = 0;
        // T - sumA 존재 여부 확인
        for (long num : sumA) {
            answer += mapB.getOrDefault(T-num, 0);
        }

        System.out.println(answer);
    }
}