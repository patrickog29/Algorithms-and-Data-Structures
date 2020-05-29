/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class Pallindrome {
        
    
    public static int isPalindrome (char a[ ], int n){

        if (n==0 || n ==1){
            return 0;
        }
        if (a[0]==a[n-1]){
            if (a.length==2){
                return 1;
            }
                
                String t = new String(a);
              
                String s = t.substring(1, t.length()-1);
               
             return isPalindrome(s.toCharArray(), s.length());
        
        }
        else {
            return 0;
        }
     
}
}
