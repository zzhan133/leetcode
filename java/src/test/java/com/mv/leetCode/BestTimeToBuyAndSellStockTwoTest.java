package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BestTimeToBuyAndSellStockTwoTest {

	private BestTimeToBuyAndSellStockTwo obj = new BestTimeToBuyAndSellStockTwo();
	
	@Test
	public void testMaxProfit() throws Exception {
		assertEquals(7, obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4} ));
	}

}
