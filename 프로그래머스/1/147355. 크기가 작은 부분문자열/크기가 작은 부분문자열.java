class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len1 = t.length();
        int len2 = p.length();
        
        for(int i=0; i<len1-len2+1; i++) {
            String str = t.substring(i, i+len2);
            if(Long.parseLong(str) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}