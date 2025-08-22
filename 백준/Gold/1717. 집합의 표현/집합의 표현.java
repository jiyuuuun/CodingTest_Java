import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int what = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(what == 0) { // 합집합
                union(a,b);
            } else { // 같은 집합인지 확인
                if(find(a) == find(b)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    // 대표 찾기
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 합치기
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA; // rootA 밑에 rootB 연결
        }
    }
}