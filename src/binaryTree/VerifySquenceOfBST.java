package binaryTree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author dell
 *
 */
public class VerifySquenceOfBST {

	public static boolean isPostArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length - 1);
	}

	/**
	 * 根据搜索二叉树的性质，比后序数组最后一个元素值小的数组会在数组的左边，比数组最后一个元素打的数组会在数组右边
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isPost(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || more == end) {
			return isPost(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end - 1);
	}

	// 方法二
	public boolean isSearchTree(int[] arr, int start, int end) {
		if (start >= end) {
			return true;
		}
		int i = start;
		for (; i < end; i++) {
			if (arr[i] > arr[end]) {
				break;
			}
		}
		for (int j = i; j < end; j++) {
			if (arr[j] < arr[end]) {
				return false;
			}
		}
		return isSearchTree(arr, start, i - 1) && isSearchTree(arr, i, end - 1);
	}

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node postToBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		Node head = new Node(arr[end]);
		int less = -1;
		int more = end;
		for (int i = 0; i < arr.length; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		head.left = postToBST(arr, start, less);
		head.right = postToBST(arr, more, end - 1);
		return head;
	}
}
