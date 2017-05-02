package com.mv.leetCode;

public class Sqrt {

	public int mySqrt(int x) {
		if (x <= 0)
			return 0;
		if (x < 4)
			return 1;
		
		int high = x - 1;
		int low = 1;
		
		while(low + 1 < high) {
			int md = (low + high) / 2;
			int value = x / md;
			if(value == md) return md;
			else if(value > md) {
				low = md;
			} else {
				high = md;
			}
		}
		return low;
	}

}
