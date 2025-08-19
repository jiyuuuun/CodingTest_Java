import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 보드의 크기
        int K = sc.nextInt(); // 사과의 개수

        int[][] board = new int[N][N];

        for (int i = 0; i < K; i++) {
            int row = sc.nextInt()-1;
            int col = sc.nextInt()-1;
            board[row][col] = 1; // 사과 표시
        }

        int L = sc.nextInt(); // 방향 변환 횟수
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            turns.put(X,C);
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int dir = 0;

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0,0}); // 시작 위치

        int time = 0;
        int x=0, y=0;

        while(true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 1. 벽에 부딪힘
            if(nx<0 || ny<0 || nx>=N || ny>=N) break;

            // 2. 자기 몸과 부딪힘
            for(int[] s : snake) {
                if(s[0] == nx && s[1] == ny) {
                    System.out.print(time);
                    return;
                }
            }

            // 3. 머리 이동
            snake.addFirst(new int[]{nx,ny});

            // 4. 사과 확인
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 먹음
            } else {
                snake.removeLast(); // 꼬리 제거
            }

            // 5. 방향 전환
            if (turns.containsKey(time)) {
                char c = turns.get(time);
                if (c == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }
}