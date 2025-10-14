import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '0' && str.charAt(i-1) == '1') {
                zeroCount++;
            } else if (str.charAt(i) == '1' && str.charAt(i-1) == '0') {
                oneCount++;
            }
        }
        
        int answer = Math.max(zeroCount, oneCount);
        
        System.out.print(answer);
    }
}