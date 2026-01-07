import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        
        int total = A * 60 + B + C;
        
        if (total >= 1440) {
            total -= 1440;
        }
        
        int newA = total / 60;
        int newB = total % 60;
        
        System.out.print(newA + " " + newB);
        
    }
}