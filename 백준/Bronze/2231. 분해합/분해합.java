import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        int answer = 0;
        
        for (int i=1; i<N; i++) {
            int sum= i;
            int temp = i;
            
            // 자리수 합 구하기
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            
            if (sum == N) {
                answer = i; // 가장 작은 생성자
                break;
            }
        }
        
        System.out.println(answer);
    }
}