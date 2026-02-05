import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] A, tmp;
    static int N, K;
    static int count = 0;
    static int answer = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열 크기
        K = Integer.parseInt(st.nextToken()); // 저장 횟수
        
        A = new int[N];
        tmp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        merge_sort(0, N-1);
        
        System.out.println(answer);
    }
    
    static void merge_sort(int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            merge_sort(p, q);
            merge_sort(q+1, r);
            merge(p, q, r);
        }
    }
    
    static void merge(int p, int q, int r) {
        int i = p, j = q+1, t = 0;
        
        // 왼쪽과 오른쪽 중 더 작은 값을 하나씩 tmp에 넣음
        while (i<=q && j<=r) {
            if (A[i] <= A[j]) tmp[t++] = A[i++];
            else tmp[t++] = A[j++];
        }
        
        while (i<=q) tmp[t++] = A[i++]; // 오른쪽이 먼저 끝난 경우
        while (j<=r) tmp[t++] = A[j++]; // 왼쪽이 먼저 끝난 경우
        
        i = p;
        t = 0;
        while (i<=r) {
            A[i] = tmp[t];
            count++;
            if (count == K) {
                answer = tmp[t];
                return;
            }
            i++;
            t++;
        }
    }
}