import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. '-' 기준으로 나누기
        String[] minus = br.readLine().split("-");
        
        int answer = 0;
        
        // 2. 첫 번째 덩어리는 그냥 더하기
        String[] first = minus[0].split("\\+");
        for (String s : first) {
            answer += Integer.parseInt(s);
        }
        
        // 3. 두 번째 덩어리부터는 전부 더해서 빼기
        for (int i=1; i<minus.length; i++) {
            String[] plus = minus[i].split("\\+");
            
            int sum = 0;
            for (String s : plus) {
                sum += Integer.parseInt(s);
            }
            
            answer -= sum;
        }
        
        System.out.println(answer);
    }
}