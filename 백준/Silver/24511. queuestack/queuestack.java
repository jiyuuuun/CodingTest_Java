import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] type = new int[N];   // 0: queue, 1: stack
        int[] value = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        // 실제로 동작하는 건 queue(0)뿐이라 덱 사용
        Deque<Integer> dq = new ArrayDeque<>();
        
        // queue인 것만 "역순으로" 덱에 넣기
        for (int i=N-1; i>=0; i--) {
            if (type[i] == 0) {
                dq.offer(value[i]);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            dq.offerLast(x);          // 새로운 값 넣고
            sb.append(dq.pollFirst()) // 맨 앞 값 출력
              .append(" ");
        }
        
        System.out.println(sb);
        
    }
}