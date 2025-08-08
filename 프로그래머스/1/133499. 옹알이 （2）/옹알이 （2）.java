class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for(String word:babbling) {
            if(isSpeakable(word, sounds)) answer++;
        }
        return answer;
    }
    
    public boolean isSpeakable(String word, String[] sounds) {
        String prev = "";
        int idx = 0;
        
        while(idx<word.length()) {
            boolean matched = false;
            
            for(String sound:sounds) {
                if(word.startsWith(sound,idx)) {
                    if(sound.equals(prev)) return false;
                    
                    prev = sound;
                    idx += sound.length();
                    matched = true;
                    break;
                }
            }
            
            if(!matched) return false;
        }
        
        return true;
    }
}