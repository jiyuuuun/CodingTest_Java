import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수
        
        int[] time = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time);
        
        int sum = 0;
        int answer = 0;
        
        for (int i=0; i<N; i++) {
            sum += time[i];
            answer += sum;
        }
        
        System.out.println(answer);
        
    }
}