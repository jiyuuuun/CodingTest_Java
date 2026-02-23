import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<M; i++) {
            int find = Integer.parseInt(st.nextToken());
            
            int left = 0;
            int right = N-1;
            boolean found = false;
            
            // 이분 탐색
            while (left <= right) {
                int mid = (left + right) / 2;
                
                if (A[mid] == find) {
                    found = true;
                    break;
                } else if (A[mid] < find){
                    left = mid +1 ;
                } else {
                    right = mid - 1;
                }
            }
            
            if (found) sb.append(1);
            else sb.append(0);
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}