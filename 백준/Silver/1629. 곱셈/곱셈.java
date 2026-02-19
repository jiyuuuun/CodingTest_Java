import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        System.out.println(power(A,B,C));
    }
    
    static long power(long A, long B, long C) {
        if (B==1)  {
            return A%C;
        }
        
        // 지수를 절반으로 나눠서 먼저 계산
        long half = power(A, B/2, C);
        
        // B가 짝수 -> A^B = (A^(B/2))^2
        if (B%2 == 0) {
            return (half*half) % C;
        } 
        // B가 홀수 -> A^B = (A^(B/2))^2*A
        else {
            return (half*half%C)*A%C;
        }
    }
}