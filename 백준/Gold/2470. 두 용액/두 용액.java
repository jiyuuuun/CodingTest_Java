import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액 수
        
        int[] A = new int[N];
        
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(A); // 정렬
        
        int left = 0;
        int right = N-1;
        
        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        
        while (left < right) {
            int sum = A[left] + A[right];
            
            // 0에 더 가까운 값이면 갱신
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = A[left];
                ans2 = A[right];
            }
            
            // 포인터 이동
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        
        System.out.println(ans1 + " " + ans2);
    }
}