import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        
        for (int i =0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int max = arr[0];
        int idx = 1;
        
        for (int i=1; i<9; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i+1;
            }
        }
        
        System.out.println(max);
        System.out.println(idx);
    }
}