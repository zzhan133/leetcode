package com.mv.leetCode;

/*
 * Simple solution: recursion
 * myPow(x, n) = myPow(x * x, n/2) or myPow(x*x, (n-1)/2) * x;
 * a. Please notice that the termination condition of the recursion; 
 * b. when n == -1 on myPow(x*x, (n-1)/2) * x;
 */

public class Pow {
	public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        
        if (n == 1) {
			return x;
		} else if(n == -1){
			return 1/x;
		}
        if(x == 1) {
            return 1;
        } else if(x == -1) {
            return n % 2 == 1 ? -1 : 1;
        }
        
        if(n % 2 == 0) {
            return myPow( x * x, n / 2);
        } else {
            return myPow(x*x, (n-1)/2) * x;
        }
	}

}
