import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수
        
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(input[0]); // 시작 시간
            meetings[i][1] = Integer.parseInt(input[1]); // 끝나는 시간
        }

        // 끝나는 시간 기준 정렬, 같으면 시작 시간 기준 정렬
        Arrays.sort(meetings, (a, b) -> {
           if (a[1] == b[1]) return a[0] - b[0];
           return a[1] - b[1];
        });

        int count = 0;
        int lastEnd = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        System.out.print(count);
    }
}