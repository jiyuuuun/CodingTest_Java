import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] medalInfo = new int[N][4];

        int kGold = 0;
        int kSilver = 0;
        int kBronze = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            medalInfo[i][0] = Integer.parseInt(input[0]); // 국가
            medalInfo[i][1] = Integer.parseInt(input[1]); // 금
            medalInfo[i][2] = Integer.parseInt(input[2]); // 은
            medalInfo[i][3] = Integer.parseInt(input[3]); // 동

            if (medalInfo[i][0] == K) {
                kGold = medalInfo[i][1];
                kSilver = medalInfo[i][2];
                kBronze = medalInfo[i][3];
            }
        }

        int count = 1;
        for (int i = 0; i < N; i++) {
            if ((kGold < medalInfo[i][1]) || 
                    (kGold == medalInfo[i][1] && kSilver < medalInfo[i][2]) ||
                    (kGold == medalInfo[i][1] && kSilver == medalInfo[i][2] && kBronze < medalInfo[i][3])) {
                count++;
            }
        }

        System.out.print(count);
    }
}