import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] extended = new int[n*2];
        
        for(int i=0; i<n*2; i++) {
            extended[i] = elements[i%n];
        }
        
        Set<Integer> sumSet = new HashSet<>();
        
        for(int i=1; i<=n; i++) {
            for(int start=0; start<n; start++) {
                int sum = 0;
                for(int k=0; k<i; k++) {
                    sum += extended[start+k];
                }
                sumSet.add(sum);
            }
        }
        
        answer = sumSet.size();
        return answer;
    }
}