import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        // 산술평균
        sb.append((int) Math.round((double) sum/N)).append("\n");
        
        // 중앙
        sb.append(arr[N/2]).append("\n");
        
        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        
        // 각 숫자의 등장 횟수 세기
        for (int x:arr) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        
        // 가장 많이 등장한 횟수 찾기
        int maxFreq = 0;
        for (int v : map.values()) {
            maxFreq = Math.max(maxFreq, v);
        }
        
        // 최빈값 후보들 수집
        List<Integer> modes = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                modes.add(key);
            }
        }
        
        Collections.sort(modes);
        
        // 여러 개면 두번째 값 선택
        if (modes.size()==1) {
            sb.append(modes.get(0)).append("\n");
        } else {
            sb.append(modes.get(1)).append("\n");
        }
    
        sb.append(arr[N-1]-arr[0]);
        
        System.out.println(sb);
    }
}