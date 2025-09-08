import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Student {
            String name;
            int korean;
            int english;
            int math;

            public Student(String name, int korean, int english, int math) {
                this.name = name;
                this.korean = korean;
                this.english = english;
                this.math = math;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            String name = input[0];
            int korean = Integer.parseInt(input[1]);
            int english = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);

            list.add(new Student(name, korean, english, math));
        }

        Collections.sort(list, (a,b) -> {
            if (a.korean != b.korean) {
                return b.korean - a.korean; // 국어 점수 내림차순
            }
            if (a.english != b.english) {
                return a.english - b.english; // 영어 점수 오름차순
            }
            if (a.math != b.math) {
                return b.math - a.math; // 수학 점수 내림차순
            }
            return a.name.compareTo(b.name); // 이름 사전순 오름차순
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);
    }
}