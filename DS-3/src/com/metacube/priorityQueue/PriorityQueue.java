package com.metacube.priorityQueue;

/**
 * This class holds functionality of priority queue
 * lowest number-> highest priority and highest number->lowest priority
 * @author Ayush Pandey
 *
 */
public class PriorityQueue {

	private static int priQueue[] = new int[5], size;

	/**
	 * To check overflow
	 * @return true if overflow
	 */
	private static boolean isFull() {
		if (size == priQueue.length)
			return true;
		return false;
	}

	/**
	 * To add new element according to priority in queue
	 * @param data to be added
	 */
	static void enqueue(int data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			int i;
			for (i=size-1; i>=0; i--)
				if (data > priQueue[i])
					priQueue[i+1] = priQueue[i];
				else
					break;
			priQueue[i+1] = data;
			size++;
		}
	}

	/**
	 * To remove top element from queue
	 * @return top element
	 */
	static int dequeue() {
		if (isEmpty()){
			System.out.println("queue is empty");
			return 0;
		}
		else
			return priQueue[--size];
	}

	/**
	 * To check underflow
	 * @return true if underflow
	 */
	private static boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * To display the queue
	 */
	static void display() {
		for (int i=0; i<size; i++)
			System.out.print("->" +priQueue[i]);
	}


	/**
	 * Driver function for priority queue.
	 */
	public static void main(String[] args){
		enqueue(10);
		enqueue(2);
		enqueue(30);
		enqueue(4);
		enqueue(5);
		display();
		System.out.println("\n dequeue " +dequeue());
		System.out.println("dequeue " +dequeue());
		enqueue(6);
		enqueue(7);
		enqueue(8);
		display();
	}
}
