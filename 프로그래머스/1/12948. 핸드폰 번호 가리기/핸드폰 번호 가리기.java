import java.util.*;

class Solution {
    public String solution(String phone_number) {
        int n = phone_number.length();
        char[] phone = new char[n];
        
        for (int i=0; i<n-4; i++) {
            phone[i] = '*'; 
        }
        for (int i=n-4; i<n; i++) {
            phone[i] = phone_number.charAt(i);
        }

        return new String(phone);
    }
}