import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        
        if (90<=score && score<=100) {
            System.out.print("A");
        } else if (80<=score && score<90) {
            System.out.print("B");
        } else if (70<=score && score<80) {
            System.out.print("C");
        } else if (60<=score && score<70) {
            System.out.print("D");
        } else {
            System.out.print("F");
        }
    }
}