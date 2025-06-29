import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t: tangerine) {
            map.put(t, map.getOrDefault(t,0) + 1);
        }
        
        List<Integer> countList = new ArrayList<>(map.values());
        countList.sort(Collections.reverseOrder());
        
        for (int count: countList) {
            sum += count;
            answer++;
            if (sum>=k) break;
        }
        
        return answer;
    }
}