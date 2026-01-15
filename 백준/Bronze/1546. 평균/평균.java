import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 과목 개수
        
        long sum = 0;
        long max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num > max) max = num;
            sum += num;
        }
        
        System.out.println(sum*100.0/max/N);
        
    }
}