import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if(num == 0){
                list.remove(list.size()-1);
            } else {
                list.add(num);
            }
        }

        int sum = 0;
        for(int num:list) {
            sum += num;
        }

        System.out.print(sum);
    }
}