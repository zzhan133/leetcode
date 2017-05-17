package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			char[] key = str.toCharArray();
			Arrays.sort(key);
			String strKey = new String(key);
			if(map.containsKey(strKey)) {
				map.get(strKey).add(str);
			} else {
				List<String> value = new ArrayList<>();
				value.add(str);
				map.put(strKey, value);
			}
		}
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k, v) -> {
        	ans.add(v);
        });
        return ans;
    }

}
