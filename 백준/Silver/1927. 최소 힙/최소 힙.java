import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 (최소 힙 - 오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
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