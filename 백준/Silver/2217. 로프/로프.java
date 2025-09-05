import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 줄의 개수
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); // 오름차순 정렬

        int answer = 0;
        for (int i = 0; i < N; i++) {
            // i번째 로프부터 끝까지 사용할 떄
            int weight = A[i] * (N-i);
            answer = Math.max(answer, weight);
        }
        
        System.out.print(answer);
    }
}