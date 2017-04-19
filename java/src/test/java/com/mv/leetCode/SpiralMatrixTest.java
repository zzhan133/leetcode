package com.mv.leetCode;

import org.junit.Test;

public class SpiralMatrixTest {

	private SpiralMatrix obj = new SpiralMatrix();
	
	@Test
	public void testSpiralSingleLayer() throws Exception {
		int [][] matrix = {
		 { 1, 2, 3 },
		 { 4, 5, 6 },
		 { 7, 8, 9 }
		};
		System.out.println(obj.spiralOrder(matrix));
	}
	
	@Test
	public void testSpiralSingleLayer1() throws Exception {
		int [][] matrix = {
		 { 1, 2, 3 }
		};
		System.out.println(obj.spiralOrder(matrix));
	}
	
	@Test
	public void testSpiralSingleLayer2() throws Exception {
		int [][] matrix = {
		 { 1, 2, 3 },
		 { 4, 5, 6 }
		};
		System.out.println(obj.spiralOrder(matrix));
	}
	
	@Test
	public void testSpiralSingleLayer3() throws Exception {
		int [][] matrix = {
		};
		System.out.println(obj.spiralOrder(matrix));
	}

}
