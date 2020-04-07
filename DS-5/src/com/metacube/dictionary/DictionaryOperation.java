package com.metacube.dictionary;

import java.util.ArrayList;

/**
 * Driver class for dictionary
 * @author Ayush
 *
 */
public class DictionaryOperation {

	public static void main(String[] args){
		DictionaryImpl dictObj = new DictionaryImpl();
		//		dictObj.insertPair(4, 71);
		//		dictObj.insertPair(15, 81);
		//		dictObj.insertPair(40, 91);
		dictObj.insertPair(84, 10);
		dictObj.insertPair(58, 11);
		//		dictObj.insertPair(45, 121);
		dictObj.sortedList();

		//		dictObj.delete(40);
		//		dictObj.delete(40);
		//		dictObj.delete(40);
		//		dictObj.delete(30);
		//		dictObj.delete(60);
		//		dictObj.delete(50);
		//		dictObj.sortedList();
		//		
		System.out.println("----------Value On Key---------");
		System.out.println(dictObj.getValue(84));
		System.out.println(dictObj.getValue(70));

		System.out.println("---------sorted in range (k1, k2)-----------");
		ArrayList<BSTNode> sorted = dictObj.sortedListInRange(30, 70);

		for(int i =0; i<sorted.size(); i++){
			System.out.println(sorted.get(i).getKey());
		}
	}
}
