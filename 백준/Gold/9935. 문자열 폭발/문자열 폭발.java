import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if(sb.length() >= bombLen) {
                boolean explode = true;
                for (int j = 0; j < bombLen; j++) {
                    if(sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        explode = false;
                        break;
                    }
                }
                if(explode) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if(sb.length() == 0) System.out.print("FRULA");
        else System.out.print(sb.toString());
    }
}