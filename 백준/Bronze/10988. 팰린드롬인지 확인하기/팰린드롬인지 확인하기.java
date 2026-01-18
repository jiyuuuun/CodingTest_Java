import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String revWord = "";
        
        int len = word.length();
        
        for (int i=len-1; i>=0; i--) {
            revWord += word.charAt(i);
        }
        
        System.out.println(word.equals(revWord) ? 1 : 0);
    }
}