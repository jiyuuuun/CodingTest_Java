import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 기타의 개수

        String[] serialNum = new String[N];
        for (int i = 0; i < N; i++) {
            serialNum[i] = br.readLine();
        }

        Arrays.sort(serialNum, (a,b) -> {
            // 1. 길이 비교
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            // 2. 숫자 합 비교
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if (sumA != sumB) {
                return sumA - sumB;
            }
            // 3. 사전순 비교
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s:serialNum) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }

    static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}