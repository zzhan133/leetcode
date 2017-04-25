package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new LinkedList<>();
		List<String> board = new ArrayList<>();
		nQueens(ans, n, board);

		return ans;
	}

	private void nQueens(List<List<String>> ans, int n, List<String> board) {
		if (board.size() == n) {
			ans.add(new ArrayList<>(board));
			return;
		}
		List<String> candidates = getCandicates(board, n);
		for (String row : candidates) {
			board.add(row);
			nQueens(ans, n, board);
			board.remove(board.size() - 1);
		}

	}

	private List<String> getCandicates(List<String> board, int n) {
		List<String> ans = new ArrayList<>();
		List<Boolean> candicates = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			candicates.add(true);
		}
		if (!board.isEmpty()) {
			int rows = board.size();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < n; j++) {
					if (board.get(i).charAt(j) == 'Q') {
						candicates.set(j, false);
						// cross attack
						int rowPos = i, leftColPos = j, rightColPos = j;
						while (rowPos < board.size()) {
							rowPos++;
							leftColPos--;
							rightColPos++;
						}
						if (leftColPos >= 0 && leftColPos < n)
							candicates.set(leftColPos, false);
						if (rightColPos >= 0 && rightColPos < n)
							candicates.set(rightColPos, false);
					}
				}
			}
		}
		for (int i = 0; i < candicates.size(); i++) {
			if (candicates.get(i)) {
				char[] arr = new char[n];
				Arrays.fill(arr, '.');
				arr[i] = 'Q';
				String item = new String(arr);
				ans.add(item);
			}
		}
		return ans;
	}

}
