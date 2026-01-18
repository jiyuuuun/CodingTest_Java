import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] chess = {1,1,2,2,2,8};
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<6; i++) {
            int white = Integer.parseInt(st.nextToken());
            sb.append(chess[i] - white).append(" ");
        }
        
        System.out.println(sb);
    }
}