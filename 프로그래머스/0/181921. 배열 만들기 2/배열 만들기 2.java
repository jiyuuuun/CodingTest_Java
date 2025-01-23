import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for (int i=l; i<=r; i++) {
            if (isMadeOfZeroAndFive(i)) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        
        return answer;
    }
    
    public static boolean isMadeOfZeroAndFive(int num) {
        String str = String.valueOf(num);
        for (char ch : str.toCharArray()) {
            if (ch != '0' && ch != '5') {
                return false;
            }
        } 
        return true;
    }
}