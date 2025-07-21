class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int a = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                answer.append(" ");
                a = 0;
            } else {
                if(a%2==0) {
                    answer.append(Character.toUpperCase(ch));
                    a++;
                } else {
                    answer.append(Character.toLowerCase(ch));
                    a++;
                }
            }
        }
        
        return answer.toString();
    }
}