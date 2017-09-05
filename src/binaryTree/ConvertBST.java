package binaryTree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author dell
 *
 */
public class ConvertBST {
	/**
	 * 1.将左子树构造成双链表，并返回链表头节点。 
	 * 2.定位至左子树双链表最后一个节点。 
	 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
	 * 4.将右子树构造成双链表，并返回链表头节点。 
	 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
	 * 6.根据左子树链表是否为空确定返回的节点。
	 * 
	 * @param pRootOfTree
	 * @return
	 */

	public static Node Convert(Node pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		Node node = pRootOfTree;
		Stack<Node> stack = new Stack<Node>();
		Connection(node, stack);

		node = stack.get(0);
		return node;
	}

	public static void Connection(Node newNode, Stack<Node> stack) {
		if (newNode == null) {
			return;
		}
		Connection(newNode.left, stack);

		if (stack.isEmpty()) {
			stack.push(newNode);

		} else {
			stack.peek().right = newNode;
			newNode.left = stack.peek();
			stack.push(newNode);

		}

		Connection(newNode.right, stack);

	}

	public Node Convert1(Node root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		// 1.将左子树构造成双链表，并返回链表头节点
		Node left = Convert(root.left);
		Node p = left;
		// 2.定位至左子树双链表最后一个节点
		while (p != null && p.right != null) {
			p = p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			p.right = root;
			root.left = p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		Node right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}

	/**
	 * 思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的最后一个节点。
	 */
	protected Node leftLast = null;

	public Node Convert2(Node root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			leftLast = root;// 最后的一个节点可能为最右侧的叶节点
			return root;
		}
		// 1.将左子树构造成双链表，并返回链表头节点
		Node left = Convert(root.left);
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			leftLast.right = root;
			root.left = leftLast;
		}
		leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
		// 4.将右子树构造成双链表，并返回链表头节点
		Node right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);

		System.out.println(Convert(head));

	}
}
