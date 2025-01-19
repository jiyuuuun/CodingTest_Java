class Solution {
    public int solution(int a, int b) {
        String result1 = String.valueOf(a) + String.valueOf(b);
        int answer1 = Integer.parseInt(result1);
        String result2 = String.valueOf(b) + String.valueOf(a);
        int answer2 = Integer.parseInt(result2);
        
        if (answer1 >= answer2) {
            return answer1;
        } else {
            return answer2;
        }
    }
}