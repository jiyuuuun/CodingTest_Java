import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()); // 영수증 총 금액
        int N = Integer.parseInt(br.readLine()); // 물건 종류의 수
        
        int sum = 0;
        
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 가격
            int b = Integer.parseInt(st.nextToken()); // 개수
            
            sum += a*b;
        }
        
        System.out.println(X==sum ? "Yes" : "No");
    }
}