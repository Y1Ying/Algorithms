package list;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 
 * @author dell
 *
 */
public class Solution {

	public static class Node {
		Node next;
		Node rand;
		int value;

		public Node(int data) {
			this.value = data;
		}
	}

	public Node copyListWithRand1(Node head) {

		if (head == null) {
			return head;
		}

		HashMap<Node, Node> map = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
}
