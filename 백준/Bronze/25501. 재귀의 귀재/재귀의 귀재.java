import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String input = br.readLine();
            count = 0;
            System.out.println(isPalindrome(input) + " " + count);
        }
        
    }
    
    static int recursion(String s, int l, int r) {
        count++;
        
        if(l >= r) return 1;
        else if(s.charAt(l) != (s.charAt(r))) return 0;
        else return recursion(s, l+1, r-1);
    }
    
    static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
}