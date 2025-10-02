import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine()); // 지불한 돈
        int restM = 1000 - M;

        int[] money = {500,100,50,10,5,1};

        int answer = 0;
        for (int i = 0; i < money.length; i++) {
            if (money[i] <= restM) {
                answer += (restM / money[i]);
                restM %= money[i];
            }
        }

        System.out.print(answer);
    }
}