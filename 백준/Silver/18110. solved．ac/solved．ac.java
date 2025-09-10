import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 의견의 개수

        int[] opinios = new int[N];
        for (int i = 0; i < N; i++) {
            opinios[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinios);
        
        int excludeCount = (int) Math.round(N*0.15); // 절사평균으로 제외되는 사람

        int sum = 0;
        for (int i = excludeCount; i < N-excludeCount; i++) {
            sum += opinios[i];
        }

        double avg = (double) sum / (N - excludeCount*2);
        int result = (int) Math.round(avg);

        System.out.print(result);
    }
}