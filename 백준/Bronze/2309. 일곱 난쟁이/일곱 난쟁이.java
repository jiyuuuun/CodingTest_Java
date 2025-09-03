import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nanList = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            nanList.add(num);
            sum += num;
        }

        int answer = sum - 100;
        int remove1 = -1, remove2 = -1;

        // 두 명 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nanList.get(i) + nanList.get(j) == answer) {
                    remove1 = nanList.get(i);
                    remove2 = nanList.get(j);
                    break;
                }
            }
            if (remove1 != -1) break;
        }

        // 찾은 두 명 제거
        nanList.remove(Integer.valueOf(remove1));
        nanList.remove(Integer.valueOf(remove2));

        Collections.sort(nanList);

        for(int num : nanList) {
            System.out.println(num);
        }
    }
}