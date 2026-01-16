import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        // 문자열 뒤집기
        String newStringA = "" + A.charAt(2) + A.charAt(1) + A.charAt(0);
        String newStringB = "" + B.charAt(2) + B.charAt(1) + B.charAt(0);

        // 문자열 -> int
        int newA = Integer.parseInt(newStringA);
        int newB = Integer.parseInt(newStringB);
        
        System.out.println(newA > newB ? newA : newB);
    }
}