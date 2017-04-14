package binaryTree;

/**
 * 在二叉树中找到一个节点的后继节点
 * 
 * @author dell
 *
 */
public class NextNode {

	public static class Node {
		public Node left;
		public Node right;
		public Node parent;
		public int value;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getLeftMost(node.right);
		} else {
			Node parent = node.parent;
			if (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
