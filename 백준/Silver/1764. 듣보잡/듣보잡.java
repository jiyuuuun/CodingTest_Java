import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine(); // 버퍼 비우기

        Set<String> unheard = new HashSet<>();

        // 듣도 못한 사람 저장
        for(int i = 0; i < N; i++) {
            unheard.add(sc.nextLine());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = sc.nextLine();
            if(unheard.contains(name)) { // 겹치는 경우
                result.add(name);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(String name:result) {
            System.out.println(name);
        }
    }
}