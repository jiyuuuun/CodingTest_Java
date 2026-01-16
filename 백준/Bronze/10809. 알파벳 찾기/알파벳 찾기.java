import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            int idx = c - 'a';
            
            // 처음 등장한 위치치
            if (arr[idx] == -1) {
                arr[idx] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
}