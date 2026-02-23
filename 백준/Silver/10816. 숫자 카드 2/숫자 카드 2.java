import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 해시를 사용한 맵
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<M; i++) {
            int check = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(check, 0)).append(" ");
        }
        
        System.out.println(sb);
    }
}