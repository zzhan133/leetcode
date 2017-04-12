package com.mv.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
	   public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> results = new ArrayList<>();
	        if(numRows <=0) {
	            return results;
	        }
	        
	        List<Integer> firstRow = new ArrayList<>();
	        firstRow.add(1);
	        for(int i = 1; i < numRows; i++) {
	            addRowItem(i, results);
	        }
	        
	        return results;
	    }
	    
	    private void addRowItem(int rowNum, List<List<Integer>> results) {
	        List<Integer> rowItem = new ArrayList<>(rowNum + 1);
	        List<Integer> rowPrev = results.get(rowNum - 1);
	        rowItem.add(1);
	        for(int i = 1; i < rowPrev.size(); i++) {
	            int value = rowPrev.get(i - 1) + rowPrev.get(i);
	            rowItem.add(value);
	        }
	        rowItem.add(1);
	        results.add(rowItem);
	    }

}
