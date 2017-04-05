package list;

import java.util.Stack;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8 ->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，
 * 8不调整，因为只有两个节点不够一组。
 * 
 * @author dell
 *
 */
public class KInverse {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public Node inverse(Node head, int K) {
		if (head == null || K < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<>();
		Node pre = null;
		Node next = null;
		Node cur = head;
		Node newHead = head;

		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == K) {
				pre = resign(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	public Node resign(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

}
