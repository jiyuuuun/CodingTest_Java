import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        if (n==0) {
            System.out.println(0);
            return;
        }
        
        long[][] base = {
                {1, 1},
                {1, 0}
        };
        
        long[][] result = power(base, n - 1);

        // F(n)은 result[0][0]
        System.out.println(result[0][0]);
    }
    
    // 행렬 거듭제곱 (분할정복)
    static long[][] power(long[][] A, long n) {
        long[][] result = {
                {1, 0},
                {0, 1}
        };
        
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, A);
            }
            
            A = multiply(A, A);
            n /= 2;
        }
        
        return result;
    }
    
    // 2x2 행렬 곱
    static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}