import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 학생 수
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        
        for (int a : arr) {
            // 보조 줄에서 보낼 수 있으면 먼저 보냄
            while (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                now++;
            }
            
            if (a == now) {
                now++; // 바로 보낼 수 있음
            } else {
                stack.push(a); // 보조 줄에 세움
            }

            // 끝났는데도 보조 줄에 남아 있으면 처리
            while (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                now++;
            }
        }
        
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        
    }
}