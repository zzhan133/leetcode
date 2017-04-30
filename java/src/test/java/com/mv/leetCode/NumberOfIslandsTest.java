package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfIslandsTest {
	
	private NumberOfIslands obj = new NumberOfIslands();

	@Test
	public void testNumIslands() throws Exception {
		char[][] grid = {{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		assertEquals(1, obj.numIslands(grid));
	}

	@Test
	public void testNumIslands2() throws Exception {
		char[][] grid = {{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		assertEquals(1, obj.numIslands(grid));
	}
}
