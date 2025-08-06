import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {2,1,2,3,2,4,2,5};
        int[] a3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == a1[i % a1.length]) answer[0]++;
            if(answers[i] == a2[i % a2.length]) answer[1]++;
            if(answers[i] == a3[i % a3.length]) answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1],answer[2]));
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == max) {
                result.add(i+1);
            }
        }
        
        int[] resultArr = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        
        return resultArr;
    }
}