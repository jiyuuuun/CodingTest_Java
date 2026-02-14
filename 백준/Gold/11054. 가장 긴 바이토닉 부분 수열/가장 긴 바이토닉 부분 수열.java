import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        
        int[] A = new int[N];
        int[] inc = new int[N]; // i번째 수를 끝으로 하는 가장 긴 증가 부분 수열
        int[] dec = new int[N]; // i번째 수를 시작으로 하는 가장 긴 감소 부분 수열
        
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 증가 부분 수열
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (A[j] < A[i]) {
                    inc[i] = Math.max(inc[i], inc[j]+1);
                }
            }
        }
        
        // 감소 부분 수열
        for (int i=N-1; i>=0; i--) {
            for (int j=N-1; j>i; j--) {
                if (A[j] < A[i]) {
                    dec[i] = Math.max(dec[i], dec[j]+1);
                }
            }
            
        }
        
        int answer = inc[0] + dec[0] - 1;
        
        for (int i=1; i<N; i++) {
            answer = Math.max(answer, inc[i] + dec[i] - 1);
        }
        
        System.out.println(answer);
    }
}