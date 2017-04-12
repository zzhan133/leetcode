package com.mv.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		System.out.println(obj.mergeStrings("abc", "def"));
		System.out.println(obj.mergeStrings("ab", "zsd"));
		
		int[] a = {6, 7, 9, 5, 6, 3, 2};
		System.out.println(obj.maxDifference(a));
		
	}
	
	public int maxDifference(int[] a) {
		if(a == null || a.length == 0) {
			return -1;
		}
		int min = a[0];
		int max = a[0];
		int result = -1;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
				max = Integer.MIN_VALUE;
			} else if(a[i] > max) {
				max = a[i];
				int tmp = max - min;
				result = tmp > result ? tmp : result;
			}
		}
		return result;
	}	

	public String mergeStrings(String a, String b) {
			if(b == null || b.length() == 0) {
				return a;
			}
			if(a == null || a.length() == 0) {
				return b;
			}
	    	StringBuilder result = new StringBuilder();
	    	int length = a.length() < b.length() ? a.length() : b.length();
	    	int index = 0;
	    	while(index < length) {
	    		result.append(a.charAt(index)).append(b.charAt(index));
	    		index++;
	    	}
	    	String remaining = a.length() > length ? a.substring(length) : b.substring(length);
	    	result.append(remaining);
	    	return result.toString();
	}

	private void twoSum(int[] num, int index, int sum, List<List<Integer>> resultSet) {
		int i = index;
		int j = num.length - 1;
		while (i < j) {
			int var = num[i] + num[j];
			if (var == sum) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(num[index - 1]);
				tmp.add(num[i]);
				tmp.add(num[j]);
				resultSet.add(tmp);
				while (++i < j && num[i] == num[i - 1])
					;
			} else {
				var = (var < sum) ? ++i : --j;
			}
		}
	}

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> resultSet = new LinkedList<List<Integer>>();

		// sort the int Array
		Arrays.sort(num);

		int i = 0;
		while (i < num.length && num[i] <= 0) {
			twoSum(num, i + 1, 0 - num[i], resultSet);
			while (++i < num.length - 1 && num[i - 1] == num[i])
				;
		}

		return resultSet;
	}

}
