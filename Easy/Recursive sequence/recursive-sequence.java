//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int m){
       return rec(m+1,1,1);
    }
     static  long rec(int m,int n,long curv)
    {
        if(n==m) return 0;
      long temp=1;
        for(int i=0;i<n;i++)
        {
            temp=((temp*curv)%1000000007);
            curv++;
        }
       return (temp+rec(m,n+1,curv))%1000000007;
    }
}