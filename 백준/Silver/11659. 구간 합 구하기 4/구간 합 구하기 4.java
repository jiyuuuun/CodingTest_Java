import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 구간 합 횟수
        
        int[] arr = new int[N+1];
        
        String[] input = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }
        
        // 누적합 배열
        int[] prefix = new int[N+1];
        prefix[0] = 0;
        
        //누적합 계산
        for (int i=1; i<=N; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            // i ~ j 구간 합
            sb.append(prefix[j] - prefix[i-1]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}