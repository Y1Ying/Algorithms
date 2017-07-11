package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换成双向链表
 * 
 * 对每一个节点来说，原来的right指针等价于转换后的next指针 原来的left指针等价于转换后的last指针
 * 
 * @author dell
 *
 */

class Node1 {
	public int value;
	public Node1 left;
	public Node1 right;

	public Node1(int data) {
		this.value = data;
	}
}

public class covert {

	public Node1 covert1(Node1 head) {
		Queue<Node1> queue = new LinkedList<>();
		inOrderToQueue(head, queue);
		Node1 pre = head;
		pre.left = null;
		Node1 cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public void inOrderToQueue(Node1 head, Queue<Node1> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
}
