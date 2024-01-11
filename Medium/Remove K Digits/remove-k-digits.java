//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public String removeKdigits(String S, int K) {
        int index = 0;
        int nonZero = 0, cut = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(index < S.length() && nonZero <= K) {
            if(S.charAt(index) != '0') {
                nonZero++;
            } else cut = index+1;
            index++;
        }
        for(int i=0; i<cut; i++) {
            if(S.charAt(i) != '0') K--;
        }
        while(cut < S.length()) {
            Integer num = Character.digit(S.charAt(cut), 10);
            while(!stack.isEmpty() && stack.peek() > num && K > 0) {
                stack.pop();
                K--;
            }
            
            stack.push(num);
            cut++;
        }
        while(!stack.isEmpty() && K > 0) {
            stack.pop();
            K--;
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        
        return ans.length() == 0 ? "0" : ans.reverse().toString();
    }
}