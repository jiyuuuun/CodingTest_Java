import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim(); // 앞뒤 공백 제거
        
        if (S.isEmpty()) { // 공백만 있던 경우
            System.out.println(0);
            return;
        }
        
        String[] words = S.split(" ");
        System.out.println(words.length);
    }
}