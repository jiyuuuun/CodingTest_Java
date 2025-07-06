import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> usedWords = new HashSet<>();
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            // 한 글자면 탈락
            if (word.length() == 1) {
                answer[0] = (i%n) + 1; // 사람 번호
                answer[1] = (i/n) + 1; // 차례
                return answer;
            }
            // 끝말잇기 실패
            if (i > 0) {
                String prev = words[i-1];
                if(prev.charAt(prev.length() - 1) != word.charAt(0)) {   
                    answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    return answer;
                }
            }
            // 중복 단어
            if (usedWords.contains(word)) {
                answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    return answer;
            }
            usedWords.add(word);
        }
        return answer;
    }
}