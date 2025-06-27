class Solution {
    public int solution(int n) {
        int answer = n+1;
        int oneCount = Integer.toBinaryString(n).replace("0","").length();
        
        while(true) {
            int nextOneCount = Integer.toBinaryString(answer).replace("0","").length();
            if (oneCount == nextOneCount) {
                return answer;
            }
            answer++;
        }
    }
}