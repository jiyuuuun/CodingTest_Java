import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String s = st.nextToken();
        int B = Integer.parseInt(st.nextToken()); // 진법
        
        int answer = Integer.parseInt(s, B);
        System.out.println(answer);
    }
}