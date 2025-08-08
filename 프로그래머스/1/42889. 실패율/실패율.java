import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int totalPlayer = stages.length;
        int[] stageCount  = new int[N+2];
        
        for(int s:stages) {
            stageCount[s]++;
        }
        
        List<StageFail> failList = new ArrayList<>();
        
        int players = totalPlayer;
        for(int i=1; i<=N; i++) {
            int fail = stageCount[i];
            double rate = (players == 0) ? 0:(double) fail / players;
            failList.add(new StageFail(i, rate));
            players -= fail;
        }
        
        Collections.sort(failList, (a, b) -> {
            if(b.failRate == a.failRate) {
                return a.stage - b.stage;
            }
            return Double.compare(b.failRate, a.failRate);
        });
        
        for(int i=0; i<N; i++) {
            answer[i] = failList.get(i).stage;
        }

        return answer;
    }
    
    class StageFail {
        int stage;
        double failRate;
        
        public StageFail(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
}