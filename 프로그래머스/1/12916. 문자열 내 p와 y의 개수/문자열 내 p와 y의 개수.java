class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') pCount++;
            else if (c == 'y') yCount++;
        }

        if (pCount == yCount) answer = true;
        else if (pCount == 0 & yCount == 0) answer = true;
        else answer = false;
        
        return answer;
    }
}