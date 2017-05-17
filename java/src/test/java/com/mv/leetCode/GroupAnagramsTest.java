package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GroupAnagramsTest {
	private GroupAnagrams obj = new GroupAnagrams();

	@Test
	public void testFourSum() throws Exception {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = obj.groupAnagrams(strs);
		ans.forEach(item -> System.out.println(item));
	}
	
	@Test
	public void testFourSum1() throws Exception {
		System.out.println(helper(10));
	}
	
    static int helper(int nmb) {
        int ans = 1;
        if(nmb % 2 == 1) {
            return 0;
        } else {
            while(nmb >= 4) {
                ans++;
                nmb = nmb - 4;
            }
            return ans;
        }
    }
    
    static String electionWinner(String[] votes) {
        Map<String, Integer> map = new HashMap<>();
        int max = 1;
        for(String name: votes) {
            if(map.containsKey(name)) {
                int times = map.get(name) + 1;
                map.put(name, times);
                if(times > max) {
                    max = times;
                }
            } else {
                map.put(name, 1);
            }
        }
        final Integer maxTimes = max; 
        List<String> cands = new ArrayList<>();
        map.forEach((k, v) -> {
            if(v.equals(maxTimes)) {
                cands.add(k);
            }
        });
        
        Collections.sort(cands);
        return cands.get(cands.size() - 1);

    }
    
    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        int ans = 0;
        HashMap<String, Float> prods = new HashMap<>();
        for(int i = 0; i < origItems.length; i++) {
            prods.put(origItems[i], origPrices[i]);
        }
        
        for(int j = 0; j < items.length; j++) {
            Float origPrice = prods.get(items[j]);
            if(!origPrice.equals(prices[j])) {
                ans++;
            }
        }

        return ans;
    }
    
	@Test
	public void testFourSum2() throws Exception {
		int[] height = {1, 2, 1, 2, 10, 9};
		System.out.println(getMinimumMoves(height));
	}
	
	@Test
	public void testFourSum3() throws Exception {
		int[] height = {1, 2, 1, 0, 10, 9};
		System.out.println(getMinimumMoves(height));
	}
	
	@Test
	public void testFourSum4() throws Exception {
		int[] height = {10, 9, 8, 7, 6, 5};
		System.out.println(getMinimumMoves(height));
	}
    
    static int getMinimumMoves(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right) {
            while(left + 1 <= right && height[left] <= height[left+1]) {
                left++;
            }
            ans++;
            if(left >= right) {
                return ans;
            }
            left++;
            while(right - 1 >= left && height[right - 1] >= height[right]) {
                right--;
            }
            ans++;
            if(left >= right) {
                return ans;
            }
            right--;
        }
        return ans;
    }
}
