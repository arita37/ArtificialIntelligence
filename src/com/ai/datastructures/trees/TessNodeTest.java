/**
 * 
 */
package com.ai.datastructures.trees;

/**
 * @author Dany
 *
 */
public class TessNodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void testTreeNode()
	{
		TreeNode<Integer, Integer> tree=new TreeNode<Integer, Integer>();
		tree.put(5, 12, null);
		tree.put(9, 21, 5);
		tree.put(11, 24, 5);
		tree.put(13, 29, 5);
		tree.put(15, 51, 5);
		tree.put(17, 76, 5);
		tree.put(19, 54, 9);
		tree.put(21, 87, 9);
		tree.put(23, 65, 9);


	}

}
