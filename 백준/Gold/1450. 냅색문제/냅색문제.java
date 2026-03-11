import java.util.*;
import java.io.*;

public class Main {
    static int N,C;
    static int[] arr;
    static ArrayList<Long> left = new ArrayList<>();
    static ArrayList<Long> right = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 물건 개수
        C = Integer.parseInt(st.nextToken()); // 최대 무게
        
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽 부분집합 합
        dfs(0, N/2, 0, left);
        
        // 오른쪽 부분집합 합
        dfs(N/2, N, 0, right);
        
        // 오른쪽 정렬
        Collections.sort(right);
        
        long answer = 0;
        
        // 왼쪽 하나씩 보면서 가능한 오른쪽 개수 찾기
        for (long l : left) {
            long remain = C-l;
            answer += upperBound(right, remain);
        }
        
        System.out.println(answer);
    }
    
    // 부분집합 합 만들기
    static void dfs(int start, int end, long sum, ArrayList<Long> list) {
        if (sum > C) return; // 무게 초과하면 중단
        
        if (start == end) {
            list.add(sum);
            return;
        }
        
        // 현재 물건 선택 안함
        dfs(start+1, end, sum, list);
        // 현재 물건 선택
        dfs(start+1, end, sum+arr[start], list);
    }
    
    // upperBound (remain 이하 개수 찾기)
    static int upperBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}