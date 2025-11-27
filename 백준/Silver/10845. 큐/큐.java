import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령 수

        Deque<Integer> dq = new ArrayDeque<>(); // Deque: 양쪽 접근 가능

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    dq.add(num);
                    break;

                case "pop" :
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.poll());
                    }
                    break;

                case "size" :
                    System.out.println(dq.size());
                    break;

                case "empty" :
                    if (dq.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "front" :
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peek());
                    }
                    break;

                case "back" :
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peekLast());
                    }
                    break;
            }
        }
    }
}