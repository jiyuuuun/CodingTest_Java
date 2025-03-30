import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int []A = new int[N+1];
        A[0] = A[1] = 0;

        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (A[i] != 0) { 
                for (int j = i * i; j <= N; j += i) {
                    A[j] = 0;
                }
            }
        }
        for (int i = M; i <= N; i++) {
            if(A[i]!=0) {
                System.out.println(A[i]);
            }
        }
    }
}