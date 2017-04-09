package binaryTree;

/**
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 
 * 给定树的根结点root，请返回树的大小。
 * 
 * @author dell
 *
 */
public class CountNodes {
	public static class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.value = data;
		}
	}

	public int count(TreeNode root) {
		// 1.先找到完全二叉树左子树最左边节点的层数。然后再找出右子树的左节点能到达的层数
		// 2.看左右子树的左节点能到的层数相等，则左子树必定是一个满二叉树，那使用满二叉树的性质求出左子树的节点数，右子树的节点数使用递归方式求出
		// 3.如果左右子树的左节点能到的层数不相等，则右子树必定是一颗少一层的满二叉树。然后左子树使用递归方法求出节点数
		return bsCount(root, 1, mostLeftlevel(root, 1));

	}

	public int bsCount(TreeNode node, int start, int height) {// start表示从头节点开始位置，height表示左子树左节点能到达的层数
		if (start == height) {
			return 1;// 只有一个头结点
		}

		if (mostLeftlevel(node.right, start + 1) == height) {// 说明左子树是一颗满二叉树:start+1是因为右子树没包含跟节点
			return (1 << (height - start)) + bsCount(node.right, start + 1, height);
		} else {// 说明右子树是比层数少一的满二叉树
			return (1 << (height - start - 1)) + bsCount(node.left, start + 1, height);
		}
	}

	public int mostLeftlevel(TreeNode node, int level) {
		while (node != null) {
			level++;// 包括了头结点
			node = node.left;
		}
		return level - 1;
	}

}
