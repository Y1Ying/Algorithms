package list;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 
 * @author dell
 *
 */

public class InsertValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public Node insertNum(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node cur = head.next;
		Node pre = head;
		while (cur != null) {
			if (pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}
}
