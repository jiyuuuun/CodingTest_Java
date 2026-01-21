import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 1;
        int layer = 1;
        
        while (N > max) {
            max += 6 * layer;
            layer++;
        }
        
        System.out.println(layer);
    }
}