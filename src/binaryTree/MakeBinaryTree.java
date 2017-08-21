package binaryTree;

/**
 * 给定数组构造一个二叉树
 * 
 * @author dell
 *
 */
public class MakeBinaryTree {

	public MakeBinaryTree(int[] arr) {
		Node head = makeBinaryTree(arr, 1);
	}

	public Node makeBinaryTree(int[] arr, int index) {
		if (index < arr.length) {
			int value = arr[index];
			if (value != 0) {
				Node cur = new Node(value);
				arr[index] = 0;
				cur.left = makeBinaryTree(arr, index * 2);
				cur.right = makeBinaryTree(arr, index * 2 + 1);
				return cur;
			}
		}
		return null;
	}
}
