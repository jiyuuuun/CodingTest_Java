import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 우선순위 큐

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if(x == 0) {
                if(heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(x);
            }
        }
    }
}