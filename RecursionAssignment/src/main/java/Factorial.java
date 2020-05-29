/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PoG
 */
public class Factorial {
    
     public static long factorial (long n)
	{
		long fact;
		fact = 1;
		while (n > 0)
		{
			fact = fact * n;
			n = n - 1;
		}
                return fact;

        }
}
