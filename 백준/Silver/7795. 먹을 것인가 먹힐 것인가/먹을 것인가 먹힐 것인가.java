import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // A 수
            int M = Integer.parseInt(st.nextToken()); // B 수

            String[] input1 = br.readLine().split(" ");
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(input1[j]);
            }

            String[] input2 = br.readLine().split(" ");
            int[] B = new int[M];
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(input2[j]);
            }

            Arrays.sort(B); // 1 3 6

            int answer = 0;

            for (int num : A) {
                int pointer = 0;
                while (pointer < M) {
                    if (B[pointer] < num) {
                        answer++;
                        pointer++;
                    } else {
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}