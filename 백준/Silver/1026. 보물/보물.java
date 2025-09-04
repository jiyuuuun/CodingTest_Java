import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input1[i]);
        }

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(input2[i]);
        }

        // A는 오름차순 정렬
        Arrays.sort(A);

        // B의 인덱스를 값 기준으로 내림차순 정렬
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i,j) -> B[j] - B[i]);

        // B는 그대로 두고, idx 순서대로 A를 배치해서 곱셈
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[idx[i]];
        }

        System.out.print(answer);
    }
}