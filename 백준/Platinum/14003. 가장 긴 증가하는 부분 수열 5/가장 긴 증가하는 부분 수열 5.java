import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; // List 길이 관리할 배열
        int[] idxArr = new int[N]; // dp에 들어간 실제 인덱스 기록 (역추적용)
        int[] parent = new int[N]; // 각 원소의 부모 인덱스 기록
        Arrays.fill(parent, -1);
        
        int len = 0; // List 길이
        int lastIndex = 0; // List 마지막 원소 인덱스

        for (int i =0; i < N; i++) {
            int num = A[i];
            
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            idxArr[left] = i;
            
            if (left > 0) parent[i] = idxArr[left - 1];
            
            if (left == len) {
                len++;
                lastIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");

        // 역추적
        Stack<Integer> stack = new Stack<>();
        int index = lastIndex;
        while (index != -1) {
            stack.push(A[index]);
            index = parent[index];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);

    }
}