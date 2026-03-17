import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        
        int[] A = new int[N]; // 수열 저장
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N]; //dp[i] : i에서 끝나는 LIS 길이
        int[] prev = new int[N]; // prev[i] : LIS에서 i 바로 이전 인덱스
        
        Arrays.fill(dp, 1); // 최소 길이는 자기 자신
        Arrays.fill(prev, -1);
        
        // LIS 길이 계산
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                // 증가 수열 가능 + 더 긴 수열이면 갱신
                if (A[j] < A[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        
        int max = 0;
        int idx = 0;
        
        // LIS 최대 길이와 마지막 위치 찾기
        for (int i=0; i<N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        
        System.out.println(max);
        
        // prev 배열을 이용해 LIS 역추적
        Stack<Integer> stack = new Stack<>();
        while (idx != -1) {
            stack.push(A[idx]);
            idx = prev[idx];
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}