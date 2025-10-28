import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 입력 데이터 수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = solve(M,N,x,y);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int solve(int M, int N, int x, int y) {
        // x를 기준으로 M씩 증가시키며 y를 맞추는 방식
        int year = x;
        while (year <= (long) M * N) {
            int b = year % N == 0 ? N : year % N;
            if (b == y) return year;
            year += M;
        }
        return -1;
    }
}