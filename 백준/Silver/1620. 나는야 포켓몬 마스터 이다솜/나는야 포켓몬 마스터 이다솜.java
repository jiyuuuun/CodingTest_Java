import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도감에 수록된 포켓몬 개수
        int M = sc.nextInt(); // 맞춰야 하는 문제의 개수

        String[] numToName = new String[N+1]; // 번호 -> 이름
        HashMap<String, Integer> nameToNum = new HashMap<>(); // 이름 -> 번호

        // 도감 만들기
        for(int i=1; i<=N; i++) {
            String monName = sc.next();
            numToName[i] = monName;
            nameToNum.put(monName, i);
        }

        for (int i = 0; i < M; i++) {
            boolean isInt = sc.hasNextInt();
            if(isInt) {
                int num = sc.nextInt();
                System.out.println(numToName[num]);
            } else {
                String str = sc.next();
                System.out.println(nameToNum.get(str));
            }
        }

    }
}