import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        
        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(a); // 정렬
        
        int x = Integer.parseInt(br.readLine());
        
        int count = 0;
        int left = 0;
        int right = n-1;
        
        // 투포인터
        while (left < right) {
            if (a[left] + a[right] < x) {
                left++;
            } else if (a[left] + a[right] > x) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }
        
        System.out.println(count);
        
    }
}