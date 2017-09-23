package binaryTree;

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

public class GetNext {

	public TreeLinkNode getNext(TreeLinkNode node) {
		if (node == null) {
			return null;
		}
		// 如果一个节点有右子树，那么他的下一个节点就是右子树的最左节点
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
		// 如果一个节点没有右子树
		while (node.next != null) {
			// 如果节点是他父节点的左子节点，那么他下一个节点就是它的父节点
			if (node.next.left == node) {
				return node.next;
			}
			// 如果一个节点既没有右子树，还是父节点的右子节点，
			// 沿着指向父节点的指针一直向上遍历，直到找到一个是他父节点的左子节点的节点，
			// 这个节点的父节点就是要找的
			node = node.next;
		}
		return null;
	}
}
