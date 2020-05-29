/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class gcd {
    
        public static int GCD (int num1, int num2) {
        
        if (num2 != 0)
            return GCD(num2, num1 % num2);
        else
            return num1;

    }
}
