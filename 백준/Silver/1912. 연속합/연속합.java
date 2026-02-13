import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int current = arr[0]; // i번째 원소에서 끝나는 최대 연속합
        int max = arr[0];  // 지금까지 나온 연속합 중 최대값
        
        for (int i=1; i<n; i++) {
            // 선택 1) arr[i]부터 새로 시작
            // 선택 2) 이전 연속합(current)에 arr[i]를 이어 붙임
            // 둘 중 더 큰 값을 선택
            current = Math.max(arr[i], current + arr[i]);
            
            // 지금까지 나온 최대 연속합 갱신
            max = Math.max(max, current);
        }
        
        System.out.println(max);
    }
}