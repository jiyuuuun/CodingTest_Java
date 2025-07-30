class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            int combined = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(combined);
            binary = String.format("%" + n + "s", binary).replace(' ','0');
            
            StringBuilder sb = new StringBuilder();
        
            for(char c:binary.toCharArray()) {
                if(c == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        

        return answer;
    }
}