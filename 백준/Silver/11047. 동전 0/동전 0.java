import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 가치 합
        
        int[] arr = new int[N];
        
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        
        // 그리디 알고리즘
         for (int i=N-1; i>=0; i--) {
            if (arr[i] <= K) {
                answer += (K/arr[i]);
                K %= arr[i];
            }
        }
        
        System.out.println(answer);
    }
}