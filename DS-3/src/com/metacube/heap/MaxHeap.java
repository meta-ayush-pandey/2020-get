package com.metacube.heap;

/**
 * Driver class for heap
 * @author Ayush Pandey
 *
 */
public class MaxHeap {
	public static int size = -1;
	public static int maxSize = 10;
	public static HeapStructure[] heap = new HeapStructure[maxSize];

	/**
	 * To find parent of curr node
	 * @param current current node
	 * @return index
	 */
	private static int parent(int current) {
		return current/2;
	}

	/**
	 * Swap two nodes
	 * @param current node at current index
	 * @param parent node at parent index
	 */
	private static void swap(int current, int parent) {
		HeapStructure temp;
		temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}

	/**
	 * To add new bowler in match
	 * @param data balls available with bowler
	 */
	private static void insert(int data) {
		if (size == -1){
			HeapStructure newHeap = new HeapStructure(data, -1);
			heap[++size] = newHeap;
		}
		else{
			HeapStructure newHeap = new HeapStructure(data, ++size);
			heap[size] = newHeap;
			int current = size;
			while (heap[current].ball > heap[parent(current)].ball){
				swap(current, parent(current));
				current = parent(current);
			}
		}
	}

	/**
	 * Driver class for starting match
	 */
	private static void matchOn() {
		while (size != 0){
			heap[1].ball -= 1;
			System.out.println("->bowler " +heap[1].bowler +" remain ball " +heap[1].ball);
			if (heap[1].ball == 0)
				extract();
			heapify(1);
		}
	}

	/**
	 * 
	 */
	private static void extract() {
		heap[1] = heap[size--];
	}

	/**
	 * Sort the nodes if top node in heap is not maximum
	 * @param pos top node
	 */
	private static void heapify(int pos) {
		if (isLeaf(pos))
			return;

		if ((heap[pos].ball < heap[leftChild(pos)].ball) || (heap[pos].ball < heap[rightChild(pos)].ball)){
			if (heap[leftChild(pos)].ball > heap[rightChild(pos)].ball){				
				swap(pos, leftChild(pos));
				heapify(leftChild(pos));
			}
			else{
				swap(pos, rightChild(pos));
				heapify(rightChild(pos));
			}
		}
	}

	/**
	 * Right child of node
	 * @param pos parent node
	 * @return child position
	 */
	private static int rightChild(int pos) {
		return pos*2+1;
	}

	/**
	 * Left child of node
	 * @param pos of parent node
	 * @return child position
	 */
	private static int leftChild(int pos) {
		return pos*2;
	}

	/**
	 * to check if curr node is leaf
	 * @param pos of curr node
	 * @return true if leaf
	 */
	private static boolean isLeaf(int pos) {
		if (pos >= (size+1)/2 && pos <= size)
			return true;
		return false;
	}

	/**
	 * Driver function for heap
	 */
	public static void main(String[] args){
		insert(Integer.MAX_VALUE);
		insert(5);
		insert(6);
		insert(7);
		matchOn();
	}

}
