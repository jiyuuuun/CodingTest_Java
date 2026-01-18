import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 20;
        
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        
        double totalScore = 0.0;
        double totalPoint = 0.0;
        
        while (total-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String sub = st.nextToken();
            double score = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급
            
            if (grade.equals("P")) continue;
            
            totalPoint += score*map.get(grade); // 총점
            totalScore += score; // 총학점
        }
        
        System.out.printf("%.6f\n", totalPoint/totalScore);
    }
}