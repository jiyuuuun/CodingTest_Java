import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(Fac(N));
        
    }
    
    static long Fac(int x) {
        if (x==0) return 1;
        return x * Fac(x-1);
    }
}