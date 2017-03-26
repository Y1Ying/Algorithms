package binaryTree;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 
 * @author dell
 *
 */
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class IdenticalTree {
	public boolean chkIdentical(TreeNode A, TreeNode B) {
		String t1Str = serialByPre(A);
		String t2Str = serialByPre(B);
		return t1Str.contains(t2Str);
	}

	private static String serialByPre(TreeNode head) {
		if (head == null) {
			return "#!";
		}

		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
}