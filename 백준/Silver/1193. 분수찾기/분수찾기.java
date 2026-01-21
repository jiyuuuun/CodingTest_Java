import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int n = 1;
        int sum = 0;
        
        while (sum < N) {
            sum += n;
            n++;
        }
        
        int line = n-1; // 실제 대각선 번호
        int pos = N - (sum - line); // 대각선 안안에서 몇 번째
        
        int numerator, denominator;
        
        // 대각선 번호가 짝수: 아래 -> 위
        if (line % 2 == 0) {
            numerator = pos;
            denominator = line - pos + 1;
        } else { // 대각선 번호가 홀수: 위 -> 아래
            numerator = line - pos + 1;
            denominator = pos;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}