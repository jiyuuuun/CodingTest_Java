import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //명령 수
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();        
        
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    dq.offerFirst(X);
                    break;
                
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    dq.offerLast(X);
                    break; 
                    
                case 3:
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break; 
                    
                case 4:
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;      
                    
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                
                case 6:
                    if (!dq.isEmpty()) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;  
                    
                case 7:
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break; 
                    
                case 8:
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;          
            }
        }
        
        System.out.println(sb);
        
    }
}