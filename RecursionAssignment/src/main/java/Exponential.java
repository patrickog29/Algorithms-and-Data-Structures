/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class Exponential {
    
      public static int exponential(int base, int pow){
       if(pow<1)
        {
            return 1;}
       
       else 
        {   
           return base*exponential(base, pow-1);
           }
       //recursive call.
    }
    
}
