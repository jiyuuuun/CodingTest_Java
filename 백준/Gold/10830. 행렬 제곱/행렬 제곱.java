import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static final int MOD = 1000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int[][] A = new int[N][N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        
        int[][] result = power(A,B);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(result[i][j]%MOD).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    // 행렬 A를 B제곱하는 함수
    static int[][] power(int[][] A, long B) {
        // 1제곱이면 자기 자신 반환
        if (B==1) return A;
        
        // A^(B/2) 먼저 구하기
        int[][] half = power(A, B/2);
        // (A^(B/2)) * (A^(B/2))
        int[][] result = multiply(half, half);
        
        // B가 홀수면 A 한 번 더 곱해줌
        if (B%2 == 1) {
            result = multiply(result, A);
        }
        
        return result;
    }
    
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];
        
        // 행렬 곱 공식
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        
        return result;
    }
}