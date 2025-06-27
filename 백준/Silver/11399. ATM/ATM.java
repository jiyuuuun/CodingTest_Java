import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int part = 0;
            for (int j = 0; j <= i; j++) {
                part += A[j];
            }
            sum += part;
        }
        System.out.print(sum);
    }
}