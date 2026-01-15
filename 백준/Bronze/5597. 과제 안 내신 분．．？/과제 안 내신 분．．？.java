import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] checkList = new boolean[31];
        
        for (int i=0; i<28; i++) {
            int num = Integer.parseInt(br.readLine());
            checkList[num] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<=30; i++) {
            if (!checkList[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}