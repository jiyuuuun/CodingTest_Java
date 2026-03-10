import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int S = Integer.parseInt(st.nextToken()); // 목표 합
        
        int[] A = new int[N];
        
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        // 슬라이딩 윈도우
        for (int right=0; right<N; right++) {
            sum += A[right]; // 윈도우 확장
            
            // 합이 S 이상이면 윈도우 줄이기
            while (sum >= S) {
                minLen = Math.min(minLen, right-left+1);
                sum -= A[left];
                left++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}