import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int intByte = N/4;
        
        StringBuilder sb = new StringBuilder();
        
        while (intByte-- > 0) {
            sb.append("long ");
        }
        
        sb.append("int");
        
        System.out.println(sb);
    }
}