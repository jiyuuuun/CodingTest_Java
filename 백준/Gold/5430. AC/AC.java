import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 개수
            String arr = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();

            // 배열 파싱
            if (n > 0) {
                arr = arr.substring(1, arr.length()-1);
                String[] nums = arr.split(",");
                for (String num : nums) {
                    dq.add(Integer.parseInt(num));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    reverse = !reverse;
                } else { // D
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reverse) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
                continue;
            }

            // 출력
            sb.append("[");
            if (!dq.isEmpty()) {
                if (!reverse) {
                    while (dq.size()>1) sb.append(dq.pollFirst()).append(",");
                    sb.append(dq.pollFirst());
                } else {
                    while (dq.size()>1) sb.append(dq.pollLast()).append(",");
                    sb.append(dq.pollLast());
                }
            }
            sb.append("]\n");
        }
        
        System.out.print(sb);
    }
}