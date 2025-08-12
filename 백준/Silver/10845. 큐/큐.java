import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            if(str.equals("push")) {
                int num = sc.nextInt();
                q.add(num);
            } else if(str.equals("pop")) {
                if(q.size()==0) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.poll());
                }
            } else if (str.equals("size")){
                System.out.println(q.size());
            } else if(str.equals("empty")) {
                if(q.size()==0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(str.equals("front")) {
                if(q.size()==0) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
            } else if(str.equals("back")) {
                if(q.size()==0) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.getLast());
                }
            }
        }
    }
}