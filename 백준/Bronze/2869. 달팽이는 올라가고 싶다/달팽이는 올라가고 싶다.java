import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        int netPerDay = A - B; // 하루 순이동 
        int targetBeforeLast = V - A; // 마지막 날 전까지 도달해야 할 높이
        
        int days = targetBeforeLast / netPerDay;
        
        if (targetBeforeLast % netPerDay != 0) {
            days++;
        }
        
        days++; // 마지막 날
        
        System.out.println(days);
    }
}