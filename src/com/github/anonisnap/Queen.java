package com.github.anonisnap;

public class Queen {
	private int x;
	private int y;

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean intersects(Queen other) {
		int deltaX = other.x - this.x;
		int deltaY = other.y - this.y;
		if (deltaX == 0 || deltaY == 0) {
			return true;
		}

		return Math.abs(((double) deltaX / (double) deltaY)) == 1d;
	}

	public boolean isOnBoard(int boardSize) {
		return (x > boardSize) || (y > boardSize) || (x < 0) || (y < 0);
	}
}
