import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 집 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기 개수
        
        int[] homes = new int[N];
        
        for (int i=0; i<N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(homes);
        
        int left = 1; // 최소 거리
        int right = homes[N-1] - homes[0]; // 최대 가능 거리
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 가정하는 거리
            
            int count = 1; // 첫 집에 설치
            int last = homes[0]; // 마지막으로 설치한 집 위치

            // mid 거리로 공유기 몇 개 설치 가능한지 계산           
            for (int i=1; i<N; i++) {
                if (homes[i] - last >= mid) {
                    count++;
                    last = homes[i];
                }
            }
            
            // 설치 가능 여부 판단
            if (count >= C) {
                answer = mid; // 일단 가능하니까 저장
                left = mid + 1; // 더 큰 거리 도전
            } else {
                right = mid - 1; // 거리 줄이기
            }
        }
        
        System.out.println(answer);
    }
}