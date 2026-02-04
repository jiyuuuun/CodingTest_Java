import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기록 수
        
        Set<String> set = new HashSet<>();
        int answer = 0;
        
        while (N-- > 0) {
            String str = br.readLine();
    
            if (str.equals("ENTER")) {
                answer += set.size(); // 이전 채팅방 정산
                set.clear();
            } else {
                set.add(str);
            }
        }
        
        // 마지막 ENTER가 없는 경우 처리
        answer += set.size();
        
        System.out.println(answer);
    }
}