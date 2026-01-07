import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int total = H * 60 + M - 45; // 분으로 바꿈
        
        if (total < 0) {
            total += 1440;
        }
        
        int newH = total / 60;
        int newM = total % 60;
        
        System.out.print(newH + " " + newM);
    }
}