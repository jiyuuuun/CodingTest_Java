import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수업

        int[][] timeTable = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            timeTable[i][0] = Integer.parseInt(input[0]);
            timeTable[i][1] = Integer.parseInt(input[1]);
        }

        // 수업 시작 시간 기준 정렬
        Arrays.sort(timeTable, (a,b) -> a[0] - b[0]);

        // 종료시간을 관리할 우선순위 큐 (가장 빨리 끝나는 수업이 맨 앞)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 수업 끝나는 시간 넣기
        pq.add(timeTable[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= timeTable[i][0]) {
                pq.poll();
            }
            pq.add(timeTable[i][1]);
        }

        System.out.print(pq.size());
    }
}