import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int last = score.length;
        
        Arrays.sort(score);
        
        for(int i=last-m; i>=0; i-=m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}