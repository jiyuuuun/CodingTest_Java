import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[][] member = new String[N][2];
        // member[i][0] = 나이
        // member[i][1] = 이름
        
        // 입력 받기 (입력 순서 그대로 저장됨)
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            member[i][0] = st.nextToken(); // 나이
            member[i][1] = st.nextToken(); // 이름
        }
        
        // 나이 오름차순 (나이가 같으면 입력 순서 유지 - 안정 정렬이라 따로 처리 필요 X)
        Arrays.sort(member, (a,b) -> {
            return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<N; i++) {
            sb.append(member[i][0]).append(" ").append(member[i][1]).append("\n");
        }
        
        System.out.println(sb);
    }
}