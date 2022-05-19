package com.github.anonisnap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting!");
		boolean findAll = false;
//		singleBoard(28, findAll);

		multipleBoards(30, findAll);
		System.out.println("Finished!");
	}

	private static void singleBoard(int size, boolean findAll) {
		Board b = new Board(size);
		b.autofillQueens(findAll);
	}

	private static void multipleBoards(int maxSize, boolean findAll) {
		Board b;
		for (int i = 0; i < maxSize; i++) {
			System.out.println("Boards at n = " + i);
			b = new Board(i);
			b.autofillQueens(findAll);
			System.out.println("Continue...");
			new Scanner(System.in).nextLine();
		}
	}
}
