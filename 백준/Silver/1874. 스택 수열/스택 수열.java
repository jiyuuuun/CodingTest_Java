import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target이 나올 때까지 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 top이 target이면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else { // 이미 top이 target보다 크면 만들 수 없음
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println(sb);
    }
}