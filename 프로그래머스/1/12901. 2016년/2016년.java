class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDays = 0;
        
        for(int i=1; i<a; i++) {
            totalDays += days[i];
        }
        
        totalDays = totalDays + b - 1;
        
        answer = week[totalDays%7];
        
        return answer;
    }
}