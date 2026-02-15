import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수 개수
        int M = Integer.parseInt(st.nextToken()); // 나누는 수
        
        long[] count = new long[M]; // 나머지 개수
        long sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int r = (int) (sum % M);
            count[r]++;
        }
        
        long answer = 0;
        
        // 나머지 0인 경우
        answer += count[0];
        
        // 같은 나머지끼리 조합
        for (int i=0; i<M; i++) {
            if (count[i] >= 2) {
                answer += count[i] * (count[i]-1) / 2;
            }
        }
        
        System.out.println(answer);
    }
}