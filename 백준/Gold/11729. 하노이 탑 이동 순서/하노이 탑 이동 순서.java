import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원판 수
        
        // 총 이동 횟수 = 2^N - 1
        System.out.println((int) Math.pow(2,N)-1);

        hanoi(N, 1, 2, 3);
        
        System.out.println(sb);
      
    }
    
    static void hanoi(int n, int from, int via, int to) {
        // 원판이 0개면 아무것도 안 함
        if (n==0) return;
        
        // 1. 위에 있는 n-1개를 보조 기둥으로 옮김
        hanoi(n-1, from, to, via);
        // 2. 가장 큰 원판 1개를 목적지로 이동
        sb.append(from).append(" ").append(to).append("\n");
        // 3. 보조 기둥에 있던 n-1개를 목적지로 옮김
        hanoi(n-1, via, from, to);
    }
}