import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        int[] time = {
            3,3,3, // ABC
            4,4,4, // DEF
            5,5,5, // GHI
            6,6,6, // JKL
            7,7,7, // MNO
            8,8,8,8, // PQRS
            9,9,9, // TUV
            10,10,10,10 // WXYZ
        };
        
        int total = 0;
        
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            int idx = c - 'A';
            total += time[idx];
        }
        
        System.out.println(total);
    }
}