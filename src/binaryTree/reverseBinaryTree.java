
package binaryTree;

import java.util.Stack;

/**
 * 反转二叉树
 * 
 * @author dell
 *
 */
public class reverseBinaryTree {

	public Node reverse1(Node root) {

		if (root == null) {
			return null;
		}
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		reverse1(root.left);
		reverse1(root.right);
		return root;
	}

	// 非递归
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			stack.pop();
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		return root;
	}
}
