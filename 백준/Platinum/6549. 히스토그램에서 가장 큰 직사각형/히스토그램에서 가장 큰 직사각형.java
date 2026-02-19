import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;
            
            long[] heights = new long[n+1];
            
            for (int i=0; i<n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }
            
            heights[n] = 0; // 마지막에 0 추가 -> 스택 비우기용
            
            Stack<Integer> stack = new Stack<>();
            long max = 0;
            
            for (int i=0; i<=n; i++) {
                // 현재 막대가 더 낮아지면
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    
                    int top = stack.pop(); // 높이 꺼냄
                    long height = heights[top];
                    
                    long width;
                    
                    if (stack.isEmpty()) {
                        width = i; // 왼쪽 끝까지 확장
                    } else {
                        width = i - stack.peek() - 1; // 왼쪽 작은 막대 다음부터
                    }
                    
                    max = Math.max(max, height*width);
                }
                
                stack.push(i);
            }
            
            System.out.println(max);
        }
    }
}