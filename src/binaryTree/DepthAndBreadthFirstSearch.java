package binaryTree;

import java.util.Stack;

/**
 * 二叉树的深度遍历和广度遍历
 * 
 * @author dell
 *
 */
public class DepthAndBreadthFirstSearch {

	public void DepthFirstSearch(Node head) {
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		System.out.println("\n");
	}
}
