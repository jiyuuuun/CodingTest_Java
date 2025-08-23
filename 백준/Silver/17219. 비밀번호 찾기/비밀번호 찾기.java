import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사이트 주소의 수
        int M = sc.nextInt(); // 찾으려는 사이트 수

        Map<String, String> sites = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sites.put(sc.next(), sc.next());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String site = sc.next();
            sb.append(sites.get(site)).append("\n");
        }
        System.out.print(sb);
    }
}