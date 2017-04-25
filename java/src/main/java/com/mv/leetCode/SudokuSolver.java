package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SudokuSolver {

	class EmptyCell {
		public EmptyCell(int i, int j, List<Character> cand) {
			rPos = i;
			cPos = j;
			candidates = cand;
		}

		int rPos;
		int cPos;
		List<Character> candidates;
	}

	public void solveSudoku(char[][] board) {
		Comparator<EmptyCell> comparator = (a, b) -> a.candidates.size() - b.candidates.size();
		PriorityQueue<EmptyCell> pq = new PriorityQueue<>(comparator);
		while (createPQ(pq, board) && !pq.isEmpty()) {
			helper(board, pq);
		}
	}

	private boolean helper(char[][] board, PriorityQueue<EmptyCell> pq) {
		if (pq.isEmpty())
			return true;
		if (pq.peek().candidates.isEmpty()) {
			return false;
		}
		PriorityQueue<EmptyCell> backup = new PriorityQueue<>(pq);
		EmptyCell cell = pq.poll();
		for (Character c : cell.candidates) {
			board[cell.rPos][cell.cPos] = c;
			updatePQ(board, pq, cell);
			if(helper(board, pq)) return true;
			board[cell.rPos][cell.cPos] = '.';
			updatePQ(board, pq, cell);
		}
		pq = backup;
		return false;
	}

	private void updatePQ(char[][] board, PriorityQueue<EmptyCell> pq, EmptyCell cell) {
		for (EmptyCell emptyCell : pq) {
			if (emptyCell.rPos == cell.rPos || emptyCell.cPos == cell.cPos
					|| (emptyCell.rPos / 3 == cell.rPos / 3 && emptyCell.cPos / 3 == cell.cPos / 3))
				emptyCell.candidates = getCandicates(board, emptyCell.rPos, emptyCell.rPos);
		}
	}

	private boolean createPQ(PriorityQueue<EmptyCell> pq, char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					List<Character> cand = getCandicates(board, i, j);
					if (cand.isEmpty())
						return false;
					pq.add(new EmptyCell(i, j, cand));
				}
			}
		}
		return true;
	}

	private List<Character> getCandicates(char[][] board, int rPos, int cPos) {
		List<Character> candidates = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
		// 1. row
		for (int i = 0; i < 9; i++) {
			if (board[rPos][i] != '.') {
				candidates.remove((Character) board[rPos][i]);
			}
		}
		// 2.col
		for (int i = 0; i < 9; i++) {
			if (board[i][cPos] != '.') {
				candidates.remove((Character) board[i][cPos]);
			}
		}
		// 3.sub
		int rBegin = rPos / 3;
		int cBegin = cPos / 3;
		for (int i = rBegin * 3; i < rBegin * 3 + 3; i++) {
			for (int j = cBegin * 3; j < cBegin * 3 + 3; j++) {
				if (board[i][j] != '.') {
					candidates.remove((Character) board[i][j]);
				}
			}
		}
		return candidates;
	}

}
