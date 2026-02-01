import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 집합에 포함된 수
        int M = Integer.parseInt(st.nextToken()); // 검사해야 하는 수
        int count = 0;
        
        Set<String> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        
        for (int i=0; i<M; i++) {
            String s = br.readLine();
            
            if (set.contains(s)) count++;
        }
        
        System.out.println(count);
    }
}