import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하느 수 개수
        int answer = 0;

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            int target = Integer.parseInt(st.nextToken());

            // 현재 위치 찾기
            int idx = 0;
            for (int x : dq) {
                if (target == x) break;
                idx++;
            }

            // 회전 방향 결정
            if (idx <= dq.size() / 2) {
                // 왼쪽 회전
                while (dq.peekFirst() != target) {
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
            } else {
                // 오른쪽 회전
                while (dq.peekFirst() != target) {
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
            }

            // 제거
            dq.pollFirst();
        }

        System.out.print(answer);

    }
}