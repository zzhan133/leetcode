package com.mv.leetCode;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FibonacciNumbersTest {

	@Test
	public void testFib() throws Exception {
		FibonacciNumbers obj = new FibonacciNumbers();
		//System.out.println(obj.fib(5));
		for (int i = 0; i < 20; i++) {
			assertTrue(obj.fib(i+1) == obj.fibDP(i + 1));
		}
		
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums == null || nums.length < 3) {
            return results;
        }

        int high = nums.length - 1;
        for(int low = 0;low <= high -2; low++) {
            if(nums[low] > 0) {
                break;
            }
            if(low > 0 && nums[low-1] == nums[low]) {
                continue;
            }
            for(int middle = low + 1; middle < high; middle++ ) {
                int sumItem = nums[low] + nums[middle] + nums[high];
                if(sumItem == 0){
                    List<Integer> item = new LinkedList<>();
                    item.add(nums[low]);
                    item.add(nums[middle]);
                    item.add(nums[high]);
                    results.add(item);
                } else if(sumItem > 0) {
                    break;
                }
                
            }
            
        }
        return results;
    }

}
