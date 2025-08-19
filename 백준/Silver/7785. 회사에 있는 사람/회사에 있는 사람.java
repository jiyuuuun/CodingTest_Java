import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 출입 기록의 수
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String person = sc.next();
            String state = sc.next();

            if(state.equals("enter")) {
                set.add(person);
            } else {
                set.remove(person);
            }
        }

        List<String> list = new ArrayList<>(set); // 리스트로 변환 후 역순 정렬
        Collections.sort(list, Collections.reverseOrder());

        for(String answer : list) {
            System.out.println(answer);
        }
    }
}