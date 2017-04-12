package binaryTree;

import java.util.Stack;

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

	// ===============递归方法===============
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

	// ===============非递归方法===============

	// 非递归先序
	public static void preOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	// 非递归中序
	public static void inOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.println(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	// 非递归后序=======使用2个栈
	public static void posOrderUnRecur1(Node head) {
		if (head != null) {
			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public void posOrderUnRecur2(Node h) {
		if (h != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.println(stack.pop().value + " ");
				}
			}
			System.out.println();
		}
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
