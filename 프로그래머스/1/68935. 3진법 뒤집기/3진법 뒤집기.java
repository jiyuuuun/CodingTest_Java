import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n>0) {
            sb.append(n%3);
            n /= 3;
        }
        
        String reversed = sb.toString();
        int len = reversed.length();
        
        for(int i=0; i<len; i++) {
            answer += (reversed.charAt(i) - '0') * Math.pow(3,len-1-i);
        }
        return answer;
    }
}