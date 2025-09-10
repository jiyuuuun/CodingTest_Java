import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] nums = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        int goodNum = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            int good = nums[i];

            while (left < right) {
                if (nums[left] + nums[right] == good && left != i && right != i) {
                    goodNum++;
                    break;
                } else if (nums[left] + nums[right] < good) {
                    left++;
                } else {
                    right--;
                }

                if (i==left) left++;
                if (i==right) right--;
            }
        }
        System.out.print(goodNum);
    }
}