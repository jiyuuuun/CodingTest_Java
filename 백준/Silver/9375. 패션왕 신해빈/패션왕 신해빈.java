import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt(); // 테스트 케이스

        for (int i = 0; i < test; i++) {
            int n = sc.nextInt(); // 의상의 수
            Map<String,Integer> kindCount = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String name = sc.next();
                String kind = sc.next();
                kindCount.put(kind, kindCount.getOrDefault(kind, 0)+1);
            }

            int result = 1;
            for(int count: kindCount.values()) {
                result *= (count + 1);
            }

            result -= 1;
            System.out.println(result);
        }
    }
}