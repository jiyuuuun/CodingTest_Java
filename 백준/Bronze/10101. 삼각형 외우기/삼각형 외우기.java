import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] ang = new int[3];
        int sum = 0;
        
        for(int i=0; i<3; i++) {
            ang[i] = Integer.parseInt(br.readLine());
            sum += ang[i];
        }
        
        if (sum == 180) {
            if (ang[0]==ang[1] && ang[1]==ang[2]) {
                System.out.println("Equilateral");
            } else if (ang[0]==ang[1] || ang[1]==ang[2] || ang[2]==ang[0]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        } 
    }
}