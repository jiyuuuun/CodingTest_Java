import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }
        
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int check = sc.nextInt();
            sb.append(countMap.getOrDefault(check, 0)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}