package binaryTree;

/**
 * 请用递归方式和非递归的方式实现二叉树的先序、中序和后序的遍历打印。
 * 
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * 
 * @author dell
 *
 */
public class TreeToSequence {

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 先序遍历
	public static void preOrderRecur(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.value + " ");
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}

	// 中序遍历
	public static void inOrderRecur(Node root) {
		if (root == null) {
			return;
		}
		preOrderRecur(root.left);
		System.out.println(root.value + " ");
		preOrderRecur(root.right);
	}

	// 后序遍历
	public static void posOrderRecur(Node root) {
		if (root == null) {
			return;
		}
		preOrderRecur(root.left);
		preOrderRecur(root.right);
		System.out.println(root.value + " ");
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();
	}

}
