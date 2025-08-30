import java.util.*;

public class Main {
    static int prec(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder result = new StringBuilder();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isLetter(ch)) { // 피연산자 바로 출력
                result.append(ch);

            } else if (ch == '(') {
                ops.push(ch);

            } else if (ch == ')'){
                while(!ops.isEmpty() && ops.peek() != '(') {
                    result.append(ops.pop());
                }
                ops.pop();

            } else {
                while(!ops.isEmpty() && prec(ops.peek()) >= prec(ch)) {
                    if (ops.peek() == '(') break;
                    result.append(ops.pop());
                }
                ops.push(ch);
            }
        }

        while(!ops.isEmpty()) { // 남은 연산자 출력
            result.append(ops.pop());
        }

        System.out.println(result);
    }
}