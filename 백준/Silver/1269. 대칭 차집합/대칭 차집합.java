import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < a; i++) {
            A.add(sc.nextInt());
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < b; i++) {
            B.add(sc.nextInt());
        }

        int both = 0;
        for (int aItem : A) {
            if(B.contains(aItem)) {
                both++;
            }
        }

        int answer = A.size() + B.size() - (both*2);
        System.out.print(answer);
    }
}