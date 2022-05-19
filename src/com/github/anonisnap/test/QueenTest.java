package com.github.anonisnap.test;

import com.github.anonisnap.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueenTest {
	private Queen q;

	@BeforeEach
	public void setup() {
		q = new Queen(5, 5);
	}

	@Test
	public void testIntersection_Horizontal() {
		boolean hit;
		hit = q.intersects(new Queen(q.getX() - 1, q.getY()));
		Assertions.assertTrue(hit);
		hit = q.intersects(new Queen(q.getX() + 1, q.getY()));
		Assertions.assertTrue(hit);
	}

	@Test
	public void testIntersection_Vertical() {
		boolean hit;
		hit = q.intersects(new Queen(q.getX(), q.getY() - 1));
		Assertions.assertTrue(hit);
		hit = q.intersects(new Queen(q.getX(), q.getY() + 1));
		Assertions.assertTrue(hit);
	}

	@Test
	public void testIntersection_Diagonal() {
		boolean hit;
		hit = q.intersects(new Queen(q.getX() - 1, q.getY() - 1));
		Assertions.assertTrue(hit);
		hit = q.intersects(new Queen(q.getX() - 1, q.getY() + 1));
		Assertions.assertTrue(hit);
		hit = q.intersects(new Queen(q.getX() + 1, q.getY() - 1));
		Assertions.assertTrue(hit);
		hit = q.intersects(new Queen(q.getX() + 1, q.getY() + 1));
		Assertions.assertTrue(hit);
	}

	@Test
	public void testIntersection_Fail() {
		boolean hit = q.intersects(new Queen(q.getX() + 2, q.getY() + 3));
		Assertions.assertFalse(hit);
	}
}
