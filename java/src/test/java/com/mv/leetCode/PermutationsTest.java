/**
 * 
 */
package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * @author Zhe
 *
 */
public class PermutationsTest {
	private Permutations obj = new Permutations();
	
	@Test
	public void testGetPermutation() throws Exception {
		int[] nums = {1, 2, 3};
		List<List<Integer>> ans = obj.permute(nums);
		assertEquals(6, ans.size());
	}
}
