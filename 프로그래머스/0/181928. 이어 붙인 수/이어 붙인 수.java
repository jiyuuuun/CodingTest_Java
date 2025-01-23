class Solution {
    public int solution(int[] num_list) {
        String odd = ""; //홀수
        String even = ""; //짝수
        for (int i=0; i<num_list.length; i++) {
            if (num_list[i] % 2 ==0) {
                even += String.valueOf(num_list[i]);
            } else {
                odd += String.valueOf(num_list[i]);
            }
        }
        return Integer.valueOf(even) + Integer.valueOf(odd);
    }
}