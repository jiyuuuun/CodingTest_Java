import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // A의 크기
        int M = Integer.parseInt(st.nextToken()); // B의 크기

        int[] A = new int[N]; // 배열A
        int[] B = new int[M]; // 배열B

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int pointerA = 0;
        int pointerB = 0;

        StringBuilder sb = new StringBuilder();
        while (pointerA < N && pointerB < M) {
            if (A[pointerA] < B[pointerB]) {
                sb.append(A[pointerA]).append(" ");
                pointerA++;
            } else {
                sb.append(B[pointerB]).append(" ");
                pointerB++;
            }
        }
        
        // 남은 요소 처리
        while (pointerA < N) {
            sb.append(A[pointerA]).append(" ");
            pointerA++;
        }
        while (pointerB < M) {
            sb.append(B[pointerB]).append(" ");
            pointerB++;
        }

        System.out.print(sb);
    }
}