package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author dell
 *
 */
public class TreeDepth {

	public int TreeDepth(TreeNode pRoot) {
		if (pRoot == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);
		int depth = 0, count = 0, nextCount = 1;
		while (queue.size() != 0) {
			TreeNode top = queue.poll();
			count++;
			if (top.left != null) {
				queue.add(top.left);
			}
			if (top.right != null) {
				queue.add(top.right);
			}
			if (count == nextCount) {
				nextCount = queue.size();
				count = 0;
				depth++;
			}
		}
		return depth;
	}

	public int TreeDepth2(TreeNode pRoot) {
		if (pRoot == null) {
			return 0;
		}
		int left = TreeDepth(pRoot.left);
		int right = TreeDepth(pRoot.right);
		return Math.max(left, right) + 1;
	}

}
