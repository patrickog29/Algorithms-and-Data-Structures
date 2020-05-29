/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class Power {
     
    public static int place (int num, int pow) 
 {
     if (num < pow){
         return pow;
     }
     return place(num, pow*10);
        
        
     
 }

}
