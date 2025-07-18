import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int len = d.length;
        
        for(int i=0; i<len; i++) {
            if(budget - d[i] >= 0) {
                answer++;
                budget -= d[i];
            } 
        }
        return answer;
    }
}