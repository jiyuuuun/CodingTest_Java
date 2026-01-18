import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        S = S.toUpperCase();
        
        int[] Alp = new int[26];
        
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            Alp[c-'A']++;
        }
        
        int max = -1;
        int idx = -1;
        boolean duplicate = false;
        
        for (int i=0; i<26; i++) {
            if (max < Alp[i]) {
                max = Alp[i];
                idx = i;
                duplicate = false;
            } else if (max == Alp[i] && max != 0) {
                duplicate = true;
            }
        }
        
        System.out.println(duplicate? "?" : (char) (idx + 'A'));
    }
}