class Solution {
    public int solution(int n) {
        int answer = 1;
        while (n > 0) {
            if (n % answer == 1) {
                return answer;
            } else {
                answer++;
            }
        }
        return 0;
    }
}