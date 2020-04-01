package com.metacube.heap;

/**
 * This holds the structure for heap nodes
 * @author Ayush Pandey
 *
 */
public class HeapStructure {
	public int ball;
	public int bowler;

	/**
	 * to initialize the object
	 * @param ball a bowler has
	 * @param bowler bowler number
	 */
	HeapStructure(int ball, int bowler) {
		this.ball = ball;
		this.bowler = bowler;
	}
}
