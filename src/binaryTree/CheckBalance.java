package binaryTree;

/**
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 
 * @author dell
 *
 */
public class CheckBalance {
	public boolean isBalance(Node root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	public int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lh = getHeight(head.left, level + 1, res);
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
}
