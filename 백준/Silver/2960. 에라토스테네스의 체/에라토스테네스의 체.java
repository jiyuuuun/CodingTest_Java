import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] removed = new boolean[N+1];
        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (!removed[i]) { // 아직 지워지지 않은 i는 소수
                for (int j = i; j <= N; j+=i) { // i의 배수 지우기
                    if (!removed[j]) {
                        removed[j] = true;
                        count++;

                        if (count == K) {
                            System.out.print(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}