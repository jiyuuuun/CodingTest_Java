import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, priority}); // {문서번호, 중요도}
                pq.offer(priority);
            }

            int count = 0;

            while (true) {
                int[] cur = q.poll();

                // 현재 문서가 가장 높은 우선순위인지 확인
                if (cur[1] == pq.peek()) {
                    pq.poll();
                    count++;

                    // 내가 찾는 문서였으면 출력
                    if (cur[0] == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    // 우선순위 아니면 뒤로 보내기
                    q.add(cur);
                }
            }
        }

        System.out.println(sb);
    }
}