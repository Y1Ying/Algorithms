package list;

/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 
 * @author dell
 *
 */
public class ClearValue {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public Node clear(Node head, int val) {
		while (head != null) {
			if (head.value != val) {
				break;
			}
			head = head.next;
		}
		Node pre = null;
		Node cur = head;

		while (cur != null) {
			if (cur.value == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

}
