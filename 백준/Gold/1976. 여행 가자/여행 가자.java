import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 여행 계획 도시 수

        // 부모 배열 (자기 자신을 부모로 시작)
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int connected = sc.nextInt();
                if (connected == 1) {
                    union(i,j); // 같은 그룹으로 묶기
                }
            }
        }

        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = sc.nextInt();
        }

        // 첫 도시의 그룹 번호
        int root = find(plan[0]);
        boolean possible = true;

        // 나머지 도시도 같은 그룹인지 확인
        for (int i = 1; i < M; i++) {
            if (find(plan[i]) != root) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    // find: 그룹의 대표 찾기
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // union: 두 도시를 같은 그룹으로 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
}