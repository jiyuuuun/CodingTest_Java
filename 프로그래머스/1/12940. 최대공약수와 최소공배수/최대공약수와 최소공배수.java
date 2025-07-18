class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = GCD(n,m);
        answer[1] = LCM(n,m);
        return answer;
    }
    
    public static int GCD(int n, int m) { //최대공약수
        if (m == 0) return n;
        return GCD(m, n%m);
    }
    
    public static int LCM(int n,int m) { // 최소공배수
        return (n*m) / GCD(n,m);
    }
}