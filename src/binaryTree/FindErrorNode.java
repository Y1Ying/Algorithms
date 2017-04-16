package binaryTree;

import java.util.Stack;

/**
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 * 
 * @author dell
 *
 */
public class FindErrorNode {
	public Node[] getTwoErrorNode(Node head) {
		if (head == null) {
			return null;
		}
		Stack<Node> stack = new Stack<>();
		Node pre = null;
		Node[] errs = new Node[2];

		while (!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if (pre != null && pre.val > head.val) {
					errs[0] = errs[0] == null ? pre : errs[0];
					errs[1] = head;
				}
				pre = head;
				head = head.right;
			}
		}
		return errs;
	}

}
