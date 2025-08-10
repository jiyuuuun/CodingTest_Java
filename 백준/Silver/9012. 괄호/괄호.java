import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            String ps = sc.next();
            String answer = "YES";
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < ps.length(); j++) {
                char ch = ps.charAt(j);

                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()) {
                answer = "NO";
            }

            System.out.println(answer);
        }
    }
}
