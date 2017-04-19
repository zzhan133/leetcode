package com.mv.leetCode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if(matrix == null || matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int layerNum = Math.min(m/2, n/2);
        for(int i = 0; i <= layerNum; i++) {
            List<Integer> singleLayer = spiralSingleLayer(matrix, i);
            ans.addAll(singleLayer);
        }
        return ans;
    }

	private List<Integer> spiralSingleLayer(int[][] matrix, int i) {
		List<Integer> items = new LinkedList<>();
		int rowLow = i;
		int rowHigh = matrix.length - i - 1;
		int colLow = i;
		int colHigh = matrix[0].length - i - 1;
		if(rowLow > rowHigh || colLow > colHigh) return items;
		for (int j = colLow; j <= colHigh; j++) {
			items.add(matrix[rowLow][j]);
		}
		for (int j = rowLow + 1; j <= rowHigh; j++) {
			items.add(matrix[j][colHigh]);
		}
		for (int j = colHigh - 1; j >= colLow && rowHigh > rowLow; j--) {
			items.add(matrix[rowHigh][j]);
		}
		for (int j = rowHigh-1; j > rowLow && colLow < colHigh; j--) {
			items.add(matrix[j][colLow]);
		}
		return items;
	}

}
