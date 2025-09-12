import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호의 수

            String[] numList = new String[n];
            for (int j = 0; j < n; j++) {
                String callNum = br.readLine();
                numList[j] = callNum;
            }

            Arrays.sort(numList); // 사전순 정렬

            boolean hasCons = true; // 일관성 체크
            for (int j = 0; j < n-1; j++) {
                if (numList[j+1].startsWith(numList[j])) {
                    sb.append("NO").append("\n");
                    hasCons = false;
                    break;
                }
            }
            if (hasCons) sb.append("YES").append("\n");

        }

        System.out.print(sb);

    }
}