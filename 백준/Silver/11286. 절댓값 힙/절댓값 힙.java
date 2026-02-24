import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            // 절댓값이 같으면
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(x);
            }
        }
        
        System.out.println(sb);
    }
}