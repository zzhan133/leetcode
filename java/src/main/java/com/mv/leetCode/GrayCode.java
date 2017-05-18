package com.mv.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> ans = new ArrayList<>();
		if (n < 0)
			return ans;
		if (n == 0) {
			ans.add(0);
			return ans;
		}
		ans.add(0);
		ans.add(1);
		int index = 2;
		while (index <= n) {
			int size = ans.size();
			int adder = 1 << (index - 1);
			for (int i = size - 1; i >= 0; i--) {
				ans.add(adder + ans.get(i));
			}
			index++;
		}
		return ans;
	}
}
