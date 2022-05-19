package com.github.anonisnap;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int boardSize;
	private final List<Queen> queenList;
	private int solutions;

	public Board(int boardSize) {
		solutions = 0;
		this.boardSize = boardSize;
		queenList = new ArrayList<>();
	}

	public boolean autofillQueens(boolean findAll) {
		if (boardSize == 0) {
			return false;
		}
		Queen q = new Queen(0, 0);
		boolean wasLarsCorrect = backtrackingAddQueen(q, findAll);
		System.out.printf("Solutions for size %d: %d%n", boardSize, solutions);
		return wasLarsCorrect;
	}

	private boolean backtrackingAddQueen(Queen newQueen, boolean findAll) {
//		System.out.println(getBoardStatus());
		if (newQueen.getY() >= boardSize) {
			System.out.println("Valid Board Found");
			System.out.println(getBoardStatus());
			solutions++;
			if (!findAll) {
				return true;
			}
		}
		for (Queen queen : queenList) {
//			System.out.println("Queen: " + queen.getX() + ", " + queen.getY());
		}
		// Check if a new queen can be placed
		for (int i = 0; i < boardSize; i++) {
//			System.out.println("Row = " + i);
			// Set new X coordinate for Queen
			newQueen.setX(i);

			// Check if Queen could be placed
			boolean queenPlaced = safeAddQueen(newQueen);
			if (queenPlaced) {
				boolean finished = backtrackingAddQueen(new Queen(0, newQueen.getY() + 1), findAll);
				if (finished) {
					System.out.println("Finished!");
					return true;
				}
//				System.out.println("Row overflow");
//				System.out.println(getBoardStatus());
				queenList.remove(newQueen);
			}
		}
		return false;
	}

	private boolean safeAddQueen(Queen q) {
		if (q.isOnBoard(boardSize)) {
			return false;
		}
		for (Queen existingQueen : queenList) {
			if (q.intersects(existingQueen)) {
				return false;
			}
		}
		queenList.add(q);
		return true;
	}

	public String getBoardStatus() {
		StringBuilder sb = new StringBuilder();
		String noQueenString = "[ ]";
		String hasQueenString = "[Q]";
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				boolean hasQueen = false;
				for (Queen q : queenList) {
					if (q.getX() == i && q.getY() == j) {
						hasQueen = true;
						break;
					}
				}
				if (hasQueen) {
					sb.append(hasQueenString)
					  .append(" ");
				} else {
					sb.append(noQueenString)
					  .append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
