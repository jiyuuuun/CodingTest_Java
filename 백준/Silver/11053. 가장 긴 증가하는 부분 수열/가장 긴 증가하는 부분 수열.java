import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        
        int[] A = new int[N];
        int[] dp = new int[N]; // i번째 수를 마지막으로 하는 LIS의 길이
        
        Arrays.fill(dp, 1);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int answer = dp[0];
        
        for (int i=1; i<N; i++) {
            if (answer < dp[i]) answer = dp[i];
        }
        
        System.out.println(answer);
    }
}