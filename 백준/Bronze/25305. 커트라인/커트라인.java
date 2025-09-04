import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 응시자의 수
        int k = Integer.parseInt(st.nextToken()); // 상을 받는 사람의 수

        int[] people = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(people);

        System.out.print(people[N-k]);

    }
}