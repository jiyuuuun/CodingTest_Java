import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] points = new int[N][2];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순
        Arrays.sort(points, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        
        System.out.println(sb);
    }
}