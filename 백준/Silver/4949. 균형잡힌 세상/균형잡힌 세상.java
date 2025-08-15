import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean result = true;

            if (str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if(ch == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') {
                        result = false;
                        break;
                    }
                    stack.pop();
                } else if(ch == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') {
                        result = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) {
                result = false;
            }
            
            System.out.println(result? "yes" : "no");
        }
    }
}