import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0; // 현재 위치
        while(!list.isEmpty()) {
            index = (index + K - 1) % list.size(); // K번째 사람 위치
            sb.append(list.get(index));
            list.remove(index);

            if(!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.print(sb);

    }
}