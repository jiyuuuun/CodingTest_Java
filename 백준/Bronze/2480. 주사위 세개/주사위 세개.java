import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        if (A==B && B==C) {
            answer = 10000+A*1000;
        } else if ((A==B) || (B==C) || (C==A)) {
            if (A==B) answer = 1000+A*100;
            else if (B==C) answer = 1000+B*100;
            else answer = 1000+C*100;
        } else {
            answer = Math.max(A, Math.max(B,C))*100;
        }
        
        System.out.print(answer);
        
    }
}