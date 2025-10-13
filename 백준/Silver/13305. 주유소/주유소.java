import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine()); // 도시 개수

        long[] distance = new long[city-1]; // 도시간 거리
        long[] price = new long[city]; // 도시의 기름 가격

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long miniPrice = price[0]; // 현재까지 가장 싼 가격

        for (int i = 0; i < city-1; i++) {
            if (price[i] < miniPrice) {
                miniPrice = price[i];
            }
            totalCost += miniPrice * distance[i];
        }

        System.out.print(totalCost);
    }
}