import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        while (N-- > 0) {
            String S = br.readLine();
            boolean[] visited = new boolean[26];
            boolean isGroup = true;
            
            for (int i=0; i<S.length(); i++) {
                char c = S.charAt(i);
                
                if (i>0 && c != S.charAt(i-1)) {
                    if (visited[c-'a']) {
                        isGroup = false;
                        break;
                    }
                }
                
                visited[c-'a'] = true;
            }
            
            if (isGroup) count++;
        }
        
        System.out.println(count);
    }
}