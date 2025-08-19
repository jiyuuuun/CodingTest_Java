import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 큐의 크기
        int M = sc.nextInt(); //뽑아내려고 하는 수의 개수
        int answer = 0; // 연산 횟수 누적

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();

            int index = 0;
            for (int num : dq) {
                if(num == target) break;
                index++;
            }

            int left = index;
            int right = dq.size() - index;

            if(left <= right) {
                for (int j = 0; j < left; j++) {
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
            } else {
                for (int j = 0; j < right; j++) {
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
            }

            dq.pollFirst();
        }
        System.out.print(answer);
    }
}