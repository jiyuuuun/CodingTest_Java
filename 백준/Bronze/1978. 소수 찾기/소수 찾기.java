import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int answer = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        
        for (int num : nums) {
            int count = 0;
            
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) count++;
            }
            
            if (count == 2) answer++;
        }
        
        System.out.print(answer);

    }
}