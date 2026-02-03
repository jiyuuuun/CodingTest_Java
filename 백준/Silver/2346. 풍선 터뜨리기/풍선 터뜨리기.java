import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //풍선 수
        
        Deque<int[]> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=1; i<=N; i++) {
            int move = Integer.parseInt(st.nextToken());
            dq.offer(new int[]{i, move}); // [풍선 번호, 이동 값]
        
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst(); // 맨 앞 풍선 터뜨림
            
            sb.append(cur[0]).append(" ");
            int move = cur[1];
            
            if (dq.isEmpty()) break;
            
            // 이동 값이 양수일 때 (오른쪽 이동)
            if (move > 0) {
                for (int i=0; i<move-1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } 
            // 이동 값이 음수일 때 (왼쪽 이동)
            else {
                for (int i=0; i<-move; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }
        
        System.out.println(sb);
        
    }
}