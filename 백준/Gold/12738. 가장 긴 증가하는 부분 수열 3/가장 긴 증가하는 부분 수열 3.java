import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 크기
        int[] A = new int[N];

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : A) {
            if (list.isEmpty() || list.get(list.size()-1) < num) {
                list.add(num);
            } else {
                int left = 0;
                int right = list.size()-1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right, num);
            }
        }

        System.out.print(list.size());
    }
}