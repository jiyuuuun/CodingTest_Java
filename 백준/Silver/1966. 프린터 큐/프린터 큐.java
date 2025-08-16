import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {

            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 궁금한 문서 위치
            
            Queue<int[]> q = new LinkedList<>(); // [중요도, 인덱스]

            for (int j = 0; j < N; j++) {
                int importance = sc.nextInt();
                q.add(new int[] {importance, j});
            }

            int seq = 0; // 출력 순서

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                boolean hasHigher = false;
                
                for(int[] doc : q) {
                    if(doc[0] > cur[0]) {
                        hasHigher = true;
                        break;
                    }
                }
                
                if(hasHigher) {
                    q.add(cur);
                } else {
                    seq++;
                    if(cur[1] == M) {
                        System.out.println(seq);
                        break;
                    }
                }
            }
        }
    }
}