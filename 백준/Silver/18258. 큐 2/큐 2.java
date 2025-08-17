import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if(command.startsWith("push")) {
                int a = Integer.parseInt(command.split(" ")[1]);
                q.add(a);
            } else if (command.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
            } else if (command.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
            } else if (command.equals("back")) {
                sb.append(q.isEmpty() ? -1 : ((LinkedList<Integer>) q).getLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}