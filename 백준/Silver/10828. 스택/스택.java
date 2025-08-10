import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String str = sc.next();

            if(str.equals("push")) {
                int pushNum = sc.nextInt();
                stack.push(pushNum);
            } else if (str.equals("pop")){
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (str.equals("size")) {
                System.out.println(stack.size());
            } else if(str.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
