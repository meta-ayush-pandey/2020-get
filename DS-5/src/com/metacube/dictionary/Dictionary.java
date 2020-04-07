package com.metacube.dictionary;

import java.util.ArrayList;

/**
 * Functionality for any dictionary
 * @author Ayush Pandey
 *
 * @param <P> key
 * @param <Q> value
 */
public interface Dictionary<P,Q> {

	/**
	 * To add new key-value pair in tree
	 * @param key of node
	 * @param value of node
	 * @param root starting element of BStree
	 * @return root node
	 */
	BSTNode addPair(P key, Q value, BSTNode root);

	/**
	 * To delete key-value pair from tree
	 * @param key to be deleted
	 * @param root of tree
	 * @return deleted node
	 */
	BSTNode deletePair(P key ,BSTNode root);

	/**
	 * To get value corresponding to a key
	 * @param key of node
	 * @param root of tree
	 * @return value
	 */
	int getValueToKey(P key, BSTNode root);

	/**
	 * To sort the tree
	 * @param root of tree
	 */
	void getSortedList(BSTNode root);

	/**
	 * To sort in a range of keys
	 * @param key1 minimum limit
	 * @param key2 maximum limit
	 * @param root of tree
	 * @return sorted list
	 */
	ArrayList<BSTNode> getSortedListRange(P key1,P key2, BSTNode root);
}