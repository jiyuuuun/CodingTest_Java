import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 탑의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>(); // {index,height}

        for (int i = 0; i < N; i++) {
            int curHeight = tops[i];

            // 현재 탑보다 작은 탑은 다 제거
            while(!stack.isEmpty() && stack.peek()[1] <= curHeight) {
                stack.pop();
            }

            // 스택이 비어있으면 왼쪽에 수신할 탑 없음
            if(stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peek()[0] + 1).append(" ");

            stack.push(new int[] {i,curHeight});
        }

        System.out.print(sb);
    }
}