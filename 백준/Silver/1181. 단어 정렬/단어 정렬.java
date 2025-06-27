import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(sc.nextLine());
        }

        List<String> wordList = new ArrayList<>(wordSet);

        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : wordList) {
            System.out.println(word);
        }
    }
}