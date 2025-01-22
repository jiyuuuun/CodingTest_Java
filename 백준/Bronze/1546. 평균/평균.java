import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];

        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            if (A[i] > max) max=A[i];
            sum += A[i];
        }
        System.out.println(sum*100.0/n/max);
    }
}