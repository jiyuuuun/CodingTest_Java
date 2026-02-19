import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        long numerator = factorial(N); // N!
        long denominator = (factorial(K) * factorial(N-K)) % MOD; // K! * (N-K)! 
        
        // 분모의 역원 구하기 (페르마의 소정리)
        long inverse = power(denominator, MOD-2);
        
        System.out.println((numerator*inverse) % MOD);
    }
    
    // 팩토리얼 계산
    static long factorial(long n) {
        long result = 1;
        for (long i=2; i<=n; i++) {
            result = (result*i) % MOD;
        }
        return result;
    }
    
    // 빠른 거듭제곱 (분할 정복)
    static long power(long base, long exp) {
        if (exp==1) {
            return base % MOD;
        }
        
        long half = power(base, exp/2);
        
        if (exp%2 == 0) {
            return (half*half) % MOD;
        } else {
            return (((half*half) % MOD)*base)%MOD;
        }
    }
}