import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> dancing  = new HashSet<>();
        dancing.add("ChongChong"); // 처음부터 춤추는 사람
        
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String A = st.nextToken();
            String B = st.nextToken();
            
            // 둘 중 하나라도 춤추고 있으면 둘 다 추가
            if (dancing.contains(A) || dancing.contains(B)) {
                dancing.add(A);
                dancing.add(B);
            }
        }
        
        System.out.println(dancing.size());
    }
}