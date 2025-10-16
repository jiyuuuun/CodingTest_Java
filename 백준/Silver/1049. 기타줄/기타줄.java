import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄 수
        int M = Integer.parseInt(st.nextToken()); // 브랜드 수

        int[] pack = new int[M]; // 6개 묶음 가격
        int[] one = new int[M]; // 낱개 가격

        // 브랜드별 가격 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 저렴한 가격만 사용하면 되므로 정렬
        Arrays.sort(pack);
        Arrays.sort(one);

        int minCost = 0;

        // 필요한 줄 수가 6 이하일 때
        if (N <= 6) {
            minCost = Math.min(pack[0], one[0] * N);
        }
        // 6개 초과일 때
        else {
            while (N >= 6) {
                // 6개 패키지가 낱개 6개보다 싸면 패키지 선택
                if (pack[0] <= one[0] * 6) {
                    minCost += pack[0];
                }
                // 아니면 남은 개수 만큼 낱개로 처리
                else {
                    minCost += one[0] * 6;
                }
                N -= 6;
            }

            minCost += Math.min(pack[0], one[0] * N);
        }

        System.out.print(minCost);
    }
}