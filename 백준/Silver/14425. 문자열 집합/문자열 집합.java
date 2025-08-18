import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집합 S에 포함된 문자열의 개수
        int M = sc.nextInt(); // 검사해야 하는 문자열의 개수

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            set.add(str);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if(set.contains(str)) answer++;
        }
        System.out.print(answer);
    }
}