import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a==0 && b==0) break;
        
            if (b % a == 0) {
                sb.append("factor");
            } else if (a % b == 0) {
                sb.append("multiple");
            } else {
                sb.append("neither");
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
}