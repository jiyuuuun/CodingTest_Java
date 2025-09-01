import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람의 수
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * (N-i);
        }
        System.out.print(sum);
    }
}