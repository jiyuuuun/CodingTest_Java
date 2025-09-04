import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수의 개수

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        // 산술평균
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        double avgDouble = (double) sum / N;
        int avg = (int) Math.round(avgDouble);
        sb.append(avg).append("\n");

        // 중앙값
        Arrays.sort(nums);
        int mid = nums[N/2];
        sb.append(mid).append("\n");

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x,0) +1);
        }

        // 1. 최빈도 찾기
        int maxFreq = Collections.max(map.values());

        // 2. 최빈값 후보 모으기
        List<Integer> candidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                candidates.add(entry.getKey());
            }
        }

        // 3. 정렬
        Collections.sort(candidates);

        // 4. 출력
        if (candidates.size() > 1) {
            sb.append(candidates.get(1)).append("\n"); // 두 번째로 작은 값
        } else {
            sb.append(candidates.get(0)).append("\n"); // 유일한 최빈값
        }


        // 범위
        int ran = nums[N-1] - nums[0];
        sb.append(ran);


        System.out.print(sb);
    }
}