import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] tri = new int[3];
            for (int i=0; i<3; i++) {
                tri[i] = Integer.parseInt(st.nextToken());
            }

            if (tri[0]==0) break;
            
            Arrays.sort(tri);
            
            if (tri[0] + tri[1] > tri[2]) {
                if (tri[0]==tri[1] && tri[1]==tri[2]) {
                    sb.append("Equilateral");
                } else if (tri[0]==tri[1] || tri[1]==tri[2] || tri[2]==tri[0]) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            } else {
                sb.append("Invalid");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}