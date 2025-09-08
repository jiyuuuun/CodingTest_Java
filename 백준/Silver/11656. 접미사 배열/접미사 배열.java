import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        LinkedList<String> strList = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            strList.add(str.substring(i));
        }

        Collections.sort(strList);

        StringBuilder sb = new StringBuilder();
        for (String s : strList) {
            sb.append(s).append("\n");
        }

        System.out.print(sb.toString());
    }
}