import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        int answer = 1;
        
        while (N > 1) {
            answer *= N;
            N--;
        }
        
        System.out.println(answer);
        
    }
}