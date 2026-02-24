import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine()); // 숫자 개수
            
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 (왼쪽)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙 (오른쪽)
            
            sb.append((M/2) + 1).append("\n"); // 출력해야 하는 중앙갑 개수
            
            int count = 0; // 현재까지 읽은 숫자 수
            int printed = 0; // 출력한 중앙갑 개수
            
            while (count < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    count++;
                    
                    // 크기 맞추기
                    if (maxHeap.size() == minHeap.size()) {
                        maxHeap.offer(num);
                    } else {
                        minHeap.offer(num);
                    }
                    
                    // 정렬 조건 맞추기
                    if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                        int a = maxHeap.poll();
                        int b = minHeap.poll();
                        maxHeap.offer(b);
                        minHeap.offer(a);
                    }
                    
                    // 홀수번째일 때 중앙값 출력
                    if (count % 2 == 1) {
                        sb.append(maxHeap.peek()).append(" ");
                        printed++;
                        
                        // 중앙값 10개마다 줄바꿈
                        if (printed % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                }
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
}