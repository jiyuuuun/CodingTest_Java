import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Character[] chars = new Character[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        
        Arrays.sort(chars, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(char c:chars) {
            sb.append(c);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}