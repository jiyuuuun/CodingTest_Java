import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); 
        
        int[] bag = new int[N+1];
        
        for (int i=1; i<=N; i++) {
            bag[i] = i;
        }
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int temp = bag[i];
            bag[i] = bag[j];
            bag[j] = temp;
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(bag[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}