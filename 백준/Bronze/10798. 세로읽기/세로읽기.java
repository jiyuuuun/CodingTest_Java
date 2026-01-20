import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] arr = new String[5];
        int maxLength = 0;
        
        for (int i=0; i<5; i++){
            arr[i] = br.readLine();
            
            maxLength = Math.max(maxLength, arr[i].length());
        }        
        
        for (int col=0; col<maxLength; col++){
            for (int row=0; row<5; row++) {
                if (col < arr[row].length()) {
                    sb.append(arr[row].charAt(col));
                }
            }
        }
        
        System.out.println(sb);
    }
}