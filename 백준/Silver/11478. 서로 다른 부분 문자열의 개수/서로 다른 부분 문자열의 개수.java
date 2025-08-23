import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int length = S.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length+1; j++) {
                set.add(S.substring(i, j));
            }
        }
        
        System.out.print(set.size());
    }
}