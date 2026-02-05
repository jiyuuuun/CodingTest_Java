import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int len = (int) Math.pow(3,N);
            
            arr = new char[len];
            Arrays.fill(arr, '-');
            
            func(0, len);
            
            System.out.println(arr);
        }
    }
    
    static void func(int start, int length) {
        if (length == 1) return;
        
        int third = length/3;
        
        // 가운데 1/3을 공백으로 만든다
        for (int i=start+third; i<start+2*third; i++) {
            arr[i] = ' ';
        }
        
        // 왼쪽, 오른쪽 재귀
        func(start, third);
        func(start+2*third, third);
    }
}