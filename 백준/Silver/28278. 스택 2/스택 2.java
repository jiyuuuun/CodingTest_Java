import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 명령의 수

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    int x = sc.nextInt();
                    stack.push(x);
                    break;

                case 2:
                    if(stack.size() > 0) {
                        sb.append(stack.pop());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                case 3:
                    sb.append(stack.size());
                    sb.append("\n");
                    break;

                case 4:
                    if(stack.size()==0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case 5:
                    if(stack.size() > 0) {
                        sb.append(stack.peek());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}