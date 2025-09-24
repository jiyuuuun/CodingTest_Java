import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()); // 수열 크기
        String[] input = br.readLine().split(" ");

        int[] A = new int[a];
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : A) {
            if (lis.isEmpty() || lis.get(lis.size()-1) < num) {
                lis.add(num); // 마지막 값보다 크면 추가
            } else {
                // 이분 탐색으로 교체 위치 찾기
                int left = 0;
                int right = lis.size()-1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                lis.set(right, num);
            }
        }

        System.out.print(lis.size());
    }

}
