class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum=0;
        for (int i=0; i<included.length; i++) {
            if (included[i] == true) {
                int num = a + d * i;
                sum += num;
            }
        }
        return sum;
    }
}