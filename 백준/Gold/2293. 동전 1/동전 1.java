import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 가치 합
        
        int[] coin = new int[n]; // 동전 종류 저장
        for (int i=0; i<n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        // dp[i] = i원을 만드는 방법의 개수
        int[] dp = new int[k+1];
        dp[0] = 1;
        
        for (int c : coin) {
            for (int i=c; i<=k; i++) {
                // (i-c)원을 만드는 방법 뒤에 동전 c를 하나 붙이면
                // 새로운 i원을 만드는 방법이 됨
                dp[i] += dp[i-c];
            }
        }
        
        System.out.println(dp[k]);
    }
}