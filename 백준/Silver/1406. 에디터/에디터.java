import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int M = sc.nextInt(); // 명령어의 개수

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기 문자열을 left 스택에 넣음
        for(char c : str.toCharArray()) {
            left.addLast(c);
        }

        for (int i = 0; i < M; i++) {
            String cmd = sc.next();
            switch (cmd) {
                case "L":
                    if(!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                case "P":
                    char add = sc.next().charAt(0);
                    left.addLast(add);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c:left) sb.append(c);
        for (char c:right) sb.append(c);
        System.out.print(sb.toString());
    }
}