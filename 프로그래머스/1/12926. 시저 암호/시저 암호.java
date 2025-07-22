class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                answer.append(' ');
            } else if (Character.isUpperCase(ch)) {
                char shifted = (char) ((ch-'A'+n) % 26 + 'A');
                answer.append(shifted);
            } else if (Character.isLowerCase(ch)) {
                char shifted = (char) ((ch-'a'+n) % 26 + 'a');
                answer.append(shifted);
            }
        }
        
        return answer.toString();
    }
}