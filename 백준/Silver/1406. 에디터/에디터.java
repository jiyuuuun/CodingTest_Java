import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "L" :
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;

                case "D" :
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;

                case "B" :
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;

                case "P" :
                    char add = st.nextToken().charAt(0);
                    left.push(add);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);

    }
}