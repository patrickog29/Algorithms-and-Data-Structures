/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class Reverse {
static int rev_num = 0;
static int base = 1;
   
public static int reverseDigits(int num) {                             // Adapted from https://www.geeksforgeeks.org/write-a-program-to-reverse-digits-of-a-number/

    if(num > 0) 
    { 
        reverseDigits(num / 10); 
        rev_num += (num % 10) * base; 
        base = base * 10; 
    } 

 return rev_num;
}

}
