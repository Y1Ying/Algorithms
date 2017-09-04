package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 二叉树的深度遍历和广度遍历
 * 
 * @author dell
 *
 */
public class DepthAndBreadthFirstSearch {

	// 深度遍历
	public void DepthFirstSearch(Node head) {
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.value + " ");
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		System.out.println("\n");
	}

	// 广度遍历
	public void BreadthFristSearch(Node head) {
		Deque<Node> deque = new ArrayDeque<>();
		deque.add(head);
		while (!deque.isEmpty()) {
			Node cur = deque.remove();
			System.out.println(cur.value + " ");
			if (cur.left != null) {
				deque.add(cur.left);
			}
			if (cur.right != null) {
				deque.add(cur.right);
			}
		}
		System.out.println("\n");
	}
}
