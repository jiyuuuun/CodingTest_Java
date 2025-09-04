import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[5];

        // 평균
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int avg = sum / 5;
        System.out.println(avg);

        // 중앙값
        Arrays.sort(nums);
        System.out.print(nums[2]);

    }
}