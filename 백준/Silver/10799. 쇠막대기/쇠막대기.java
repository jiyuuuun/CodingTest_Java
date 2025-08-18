import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stack.push(ch);

            } else {
                stack.pop();
                if(str.charAt(i-1) == '(') { // 레이저
                    answer += stack.size();
                }
                else {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}