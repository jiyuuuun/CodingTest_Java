import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열
        int q = Integer.parseInt(br.readLine()); // 질문 수
        
        // 누적합 배열: prefix[i][c]
        // 0번부터 i번까지 문자 c가 몇 번 나왔는지
        int[][] prefix = new int[S.length()][26];
        
        // 누적합 계산
        for (int i=0; i<S.length(); i++) {
            if (i > 0) {
                // 이전 값 복사
                for (int j=0; j<26; j++) {
                    prefix[i][j] = prefix[i-1][j];
                }
            }
            // 현재 문자 카운트 증가            
            prefix[i][S.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken()); // 구간 시작
            int r = Integer.parseInt(st.nextToken()); // 구간 끝
            
            int idx = c - 'a';
            
            if (l == 0) {
                sb.append(prefix[r][idx]);
            } else {
                sb.append(prefix[r][idx] - prefix[l-1][idx]);
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
}