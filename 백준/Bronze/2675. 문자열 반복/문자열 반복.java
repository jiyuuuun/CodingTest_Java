import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()); // 반복 횟수
            String S = st.nextToken(); // 문자열
            
            for (int i=0; i<S.length(); i++) {
                char c = S.charAt(i);
                
                for (int j=0; j<R; j++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}