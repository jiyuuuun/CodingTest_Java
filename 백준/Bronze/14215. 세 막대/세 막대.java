import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] tri = new int[3];
        for(int i=0; i<3; i++) {
            tri[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(tri);
        
        if (tri[0] + tri[1] <= tri[2]) {
            tri[2] = tri[0] + tri[1] - 1;
        }
        
        int answer = tri[0] + tri[1] + tri[2];
        
        System.out.println(answer);
    }
}