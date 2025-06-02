class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isWordOfStart = true;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(c);
                isWordOfStart = true;
            } else {
                if (isWordOfStart) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                isWordOfStart = false;
            }
        }
        return answer.toString();
    }
}