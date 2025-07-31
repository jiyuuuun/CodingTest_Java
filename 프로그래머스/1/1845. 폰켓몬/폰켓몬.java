import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int n:nums) {
            set.add(n);
        }
        
        int maxPick = nums.length / 2;
        
        answer = Math.min(set.size(), maxPick);
            
        return answer;
    }
}