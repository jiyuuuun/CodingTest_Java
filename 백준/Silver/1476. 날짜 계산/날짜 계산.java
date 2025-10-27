import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()); // 지구 주기
        int S = Integer.parseInt(st.nextToken()); // 태양 주기
        int M = Integer.parseInt(st.nextToken()); // 달 주기

        int year = 1;
        int range = 15 * 28 * 19; // 세 주기의 최대 반복 범위

        // 1년부터 최대 범위까지 반복
        while (year <= range) {
            int e = year % 15 == 0 ? 15 : year % 15; // 나머지가 0이면 주기 끝 값으로 바꿔줘야 함
            int s = year % 28 == 0 ? 28 : year % 28;
            int m = year % 19 == 0 ? 19 : year % 19;

            // 입력값과 현재 연도의 값이 모두 일치
            if (E==e && S==s && M==m) {
                break;
            } else {
                year++;
            }
        }

        System.out.print(year);

    }
}