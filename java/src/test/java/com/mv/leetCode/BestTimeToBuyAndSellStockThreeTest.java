package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BestTimeToBuyAndSellStockThreeTest {
	
	private BestTimeToBuyAndSellStockThree obj = new BestTimeToBuyAndSellStockThree();

	@Test
	public void testMaxProfit() throws Exception {
		assertEquals(7, obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4} ));
	}

	@Test
	public void testMaxProfit1() throws Exception {
		assertEquals(7, obj.maxProfit(new int[]{6,1,3,2,4,7} ));
	}
	
	@Test
	public void testMaxProfit2() throws Exception {
		assertEquals(13, obj.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0} ));
	}
	
	@Test
	public void testMaxProfit3() throws Exception {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		int[] g = obj.getMaxProfit(prices);
		for (int i = 0; i < prices.length ; i++) {
			//assertEquals(g[i], obj.getMaxProfit(prices, i, prices.length - 1));
		}
	}
	
	@Test
	public void testMaxProfit4() throws Exception {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		int[] g = obj.getMaxProfitFromEndToBegin(prices);
		for (int i = 0; i < prices.length ; i++) {
			System.out.print(g[i] + " ");
		}
	}
}
