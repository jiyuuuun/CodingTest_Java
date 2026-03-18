import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        
        int n = A.length();
        int m = B.length();
        
        // dp[i][j] : A의 i번째까지, B의 j번째까지의 LCS 길이
        int[][] dp = new int[n+1][m+1];
        
        // DP 테이블 채우기
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                
                // 문자가 같으면 LCS 길이+1
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // 역추적
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        
        while (i>0 && j>0) {
            if (A.charAt(i-1) == B.charAt(j-1)) {
                sb.append(A.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        
        sb.reverse(); // 역추적으로 문자열을 뒤집어서 저장했기 때문에 reverse
        
        System.out.println(dp[n][m]);
        System.out.print(sb);
    }
}