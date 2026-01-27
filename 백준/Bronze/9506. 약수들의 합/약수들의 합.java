import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            
            for (int i=1; i<n; i++) {
                if (n % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }
            
            if (n == sum) {
                sb.append(n + " = ");
                for (int i=0; i<list.size(); i++) {
                    sb.append(list.get(i));
                    
                    if (i != list.size() - 1) {
                        sb.append(" + ");
                    }
                }
            } else {
                sb.append(n + " is NOT perfect.");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}