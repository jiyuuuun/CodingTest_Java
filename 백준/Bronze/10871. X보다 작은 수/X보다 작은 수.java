import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수열 개수
        int X = Integer.parseInt(st.nextToken()); // 기준 
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num < X) {
                sb.append(num).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}