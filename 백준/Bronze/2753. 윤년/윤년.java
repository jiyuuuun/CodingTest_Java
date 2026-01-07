import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        boolean yunyear = false;
        
        if (year%4 == 0) {
            if (year%100!=0 || year%400==0) {
                yunyear = true;
            }
        }
        
        if (yunyear) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}