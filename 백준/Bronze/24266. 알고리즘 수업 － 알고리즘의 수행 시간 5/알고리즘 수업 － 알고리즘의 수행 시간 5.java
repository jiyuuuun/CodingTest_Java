import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        System.out.println(n*n*n); // 수행횟수: n*n*n
        System.out.println(3); // 시간복잡도: O(n^3)
    }
}