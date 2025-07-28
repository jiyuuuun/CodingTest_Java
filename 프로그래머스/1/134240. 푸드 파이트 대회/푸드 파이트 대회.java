class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            int n = food[i] / 2;
            for(int j=0; j<n; j++) {
                sb.append(i);
            }
        }
        
        sb.append(0);
        
        for(int i=food.length-1; i>0; i--) {
            int m = food[i] / 2;
            for(int j=0; j<m; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}