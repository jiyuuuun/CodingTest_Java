import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.lang.Math.floor;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 게임 횟수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임
        int Z = (int) ((Y * 100) / X); // 현재 승률

        // 이미 승률 99% 이상이면 오를 수 없음
        if (Z >= 99) {
            System.out.print(-1);
            return;
        }

        long left = 1;
        long right = 1000000000;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newRate = ((Y + mid) * 100) / (X + mid);

            if (newRate > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.print(answer);
    }
}