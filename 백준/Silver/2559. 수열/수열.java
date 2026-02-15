import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 전제 날짜 수
        int K = Integer.parseInt(st.nextToken()); // 연속 날짜 수
        
        // 온도 배열
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        // 처음 K일 합 계산
        int sum = 0;
        for (int i=0; i<K; i++) {
            sum += arr[i];
        }
        
        int max = sum; 
        
        // 슬라이딩 윈도우
        for (int i=1; i<=N-K; i++) {
            sum = sum - arr[i-1] + arr[i+K-1]; // 왼쪽 빼고 오른쪽 더하기
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
        
    }
}