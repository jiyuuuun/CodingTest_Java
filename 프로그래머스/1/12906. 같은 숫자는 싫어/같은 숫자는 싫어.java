import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        
        for(int i=0; i<len; i++) {
            if(stack.isEmpty() || arr[i] != stack.peek()) {
                stack.push(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}