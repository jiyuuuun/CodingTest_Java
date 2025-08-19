import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 크기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>(); // 인덱스 저장

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int idx = stack.pop();
                result[idx] = A[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int r:result) {
            sb.append(r).append(" ");
        }
        System.out.print(sb.toString());
    }
}