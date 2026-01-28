import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] x = new int[3];
        int[] y = new int[3];
        
        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        int rx, ry;
        
        if (x[0] == x[1]) rx = x[2];
        else if (x[0] == x[2]) rx = x[1];
        else rx = x[0];
        
        if (y[0] == y[1]) ry = y[2];
        else if (y[0] == y[2]) ry = y[1];
        else ry = y[0];
        
        System.out.println(rx + " " + ry);
        
    }
}