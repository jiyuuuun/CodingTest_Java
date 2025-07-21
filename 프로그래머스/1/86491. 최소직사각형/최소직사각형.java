class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0; i<sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (w<h) {
                sizes[i][0] = h;
                sizes[i][1] = w;
            }
        }
        
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i=0; i<sizes.length; i++) {
            if (maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            if (maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }
        
        answer = maxWidth * maxHeight;
        return answer;
    }
}