package com.mv.leetCode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

	public int trap(int[] height) {
		//get ascending values
		if(height == null || height.length < 3) return 0;
		List<Integer> asc = new ArrayList<>();
		asc.add(0);
		for (int i = 1; i < height.length; i++) {
			int lastElem = height[ asc.get(asc.size() - 1)];
			if (lastElem < height[i]) {
				asc.add(i);
			}
		}
		int ans = 0;
		for (int i = 0; i < asc.size() - 1; i++) {
			int hgt = height[asc.get(i)];
			int walker = asc.get(i) + 1;
			int des = asc.get(i + 1);
			while(walker < des) {
				ans += (hgt - height[walker]);
				walker++;
			}
			
		}
		//get desc indecis
		List<Integer> desc = new ArrayList<>();
		desc.add(height.length - 1);
		int maxIndex = asc.get(asc.size() - 1);
		for (int i = height.length - 2; i >= maxIndex; i--) {
			int lastElem = height[desc.get(desc.size() - 1)];
			if(lastElem < height[i]) {
				desc.add(i);
			}
		}
		desc.add(maxIndex);
		for (int i = 0; i < desc.size() - 1; i++) {
			int hgt = height[desc.get(i)];
			int walker = desc.get(i) - 1;
			int des = desc.get(i + 1);
			while(walker > des) {
				ans += (hgt - height[walker]);
				walker--;
			}
		}
		return ans;
	}
}
