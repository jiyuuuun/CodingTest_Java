import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 팔린 책의 개수

        Map<String, Integer> bookList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            bookList.put(bookName, bookList.getOrDefault(bookName, 0) + 1);
        }

        int maxSell = 0;
        String bestSeller = "";

        for (Map.Entry<String, Integer> entry : bookList.entrySet()) {
            String book = entry.getKey();
            int cnt = entry.getValue();

            if (cnt > maxSell) {
                maxSell = cnt;
                bestSeller = book;
            } else if (cnt == maxSell && book.compareTo(bestSeller) < 0) {
                bestSeller = book;
            }
        }

        System.out.print(bestSeller);
    }
}