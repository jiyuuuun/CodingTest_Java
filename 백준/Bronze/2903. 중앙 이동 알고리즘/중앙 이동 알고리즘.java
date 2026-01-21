import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int point = 2; // 처음점 2개
        
        for (int i=1; i<=N; i++) {
            point += Math.pow(2, i-1);
        }
        
        int answer = point * point;
        
        System.out.println(answer);
    }
}