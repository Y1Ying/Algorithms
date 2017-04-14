package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 
 * @author dell
 *
 */
public class CheckCompletion {
	public boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		boolean leaf = false;
		Node l = null;
		Node r = null;
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			// 左右孩子不为空，之后节点不是叶节点 有右孩子没有左孩子
			if ((leaf && (l != null || r != null)) || (r != null && l == null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}
}
