import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        while(T-- > 0) {
            String p = sc.next(); // 수행할 함수
            int n = sc.nextInt(); // 배열에 들어있는 개수
            String input = sc.next();

            input = input.replace("[", "").replace("]", "");
            String[] parts = input.isEmpty() ? new String[0] : input.split(",");

            Deque<Integer> arr = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(parts[i]));
            }

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                char ch = p.charAt(i);

                if (ch == 'R') {
                    reversed = !reversed;
                } else { // D
                    if (arr.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    if (!reversed) arr.pollFirst(); // 정방향 -> 앞에서 제거
                    else arr.pollLast(); // 뒤집힌 상태 -> 뒤에서 제거
                }
            }

            if(!error) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!arr.isEmpty()) {
                    sb.append(reversed? arr.pollLast() : arr.pollFirst());
                    if(!arr.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}