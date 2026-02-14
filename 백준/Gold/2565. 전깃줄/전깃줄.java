import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전깃줄 개수
        
        int[][] line = new int[N][2];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            line[i][0] = A;
            line[i][1] = B;
        }
        
        // 정렬
        Arrays.sort(line, (a, b) -> {
            return a[0] - b[0];
        });
        
        int[] arr = new int[N]; // B 값들
        
        // B 배열 추출
        for (int i=0; i<N; i++) {
            arr[i] = line[i][1];
        }
        
        // LIS
        int[] lis = new int[N];
        Arrays.fill(lis, 1);
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        
        int max = lis[0];
        for (int i=1; i<N; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        
        System.out.println(N - max);
        
    }
}