import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusSplit = br.readLine().split("-");
        int answer = 0;

        for (String part : minusSplit[0].split("\\+")) {
            answer += Integer.parseInt(part);
        }

        for (int i = 1; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int sum = 0;
            for (String part : plusSplit) {
                sum += Integer.parseInt(part);
            }
            answer -= sum;
        }

        System.out.print(answer);

    }
}