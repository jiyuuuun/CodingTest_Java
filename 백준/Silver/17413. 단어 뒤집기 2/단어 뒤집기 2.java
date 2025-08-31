import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean inTag = false; // 태그 안에 있는지 여부 체크

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                inTag = false;
                sb.append(ch);
            } else if (inTag) { // 태그 안이면 그대로 출력
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) { // 남아있는 단어 처리
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }
}