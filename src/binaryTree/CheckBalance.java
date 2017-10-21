package binaryTree;

/**
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 
 * @author dell
 *
 */
public class CheckBalance {
	public static boolean isBalance(Node root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lh = getHeight(head.left, level + 1, res);
		// 若为不平衡树，直接退出
		if (!res[0]) {
			return level;
		}
		int rh = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lh - rh) > 1) {
			res[0] = false;
		}
		return Math.max(lh, rh);
	}

	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
			return false;

		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}
}
