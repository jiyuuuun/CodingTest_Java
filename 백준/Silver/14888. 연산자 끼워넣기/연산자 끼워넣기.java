import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N; // 수의 개수
    static int[] numbers;
    static int[] operators = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수의 개수
        numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, numbers[0]);
        
        System.out.println(max);
        System.out.println(min);
        
    }
    
    static void dfs(int idx, int result) {
        // 모든 숫자를 다 사용한 경우
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        for (int i=0; i<4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용
                
                if (i==0) { // +
                    dfs(idx+1, result + numbers[idx]);
                } else if (i==1) { // -
                    dfs(idx+1, result - numbers[idx]);
                } else if (i==2) { // *
                    dfs(idx+1, result * numbers[idx]);
                } else { // /
                    dfs(idx+1, result / numbers[idx]);
                }
            
                operators[i]++; // 사용한 연산자 복구 (백트래킹)
            }
        }
    }
}