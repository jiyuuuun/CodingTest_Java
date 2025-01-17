class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        String firstPart = my_string.substring(0, s);
        String overwritePart = overwrite_string;
        String lastPart = my_string.substring(s + overwrite_string.length());
        
        answer = firstPart + overwritePart + lastPart ;
        return answer;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution);
    }
}