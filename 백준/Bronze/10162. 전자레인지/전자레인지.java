import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 요리시간

        int a = T / 300;
        T %= 300;
        
        int b = T / 60;
        T %= 60;
        
        int c = T / 10;
        T %= 10;
        
        if (T == 0) {
            System.out.print(a + " " + b + " " + c);
        } else {
            System.out.print(-1);
        }
    }
}