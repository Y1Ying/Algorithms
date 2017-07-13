package list;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。不给定整个链表的头结点
 * 
 * @author dell
 *
 */
public class RemoveNodeWired {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	// 此种解法无法删除最后一个节点
	public static void removeNodeWired(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			throw new RuntimeException("can not remove last node.");
		}
		node.value = next.value;
		node.next = next.next;

	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node node = head;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		node = head.next;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);

		// head = new Node(1);
		// head.next = new Node(2);
		// head.next.next = new Node(3);
		// node = head.next.next;
		// printLinkedList(head);
		// removeNodeWired(node);
		// printLinkedList(head);

	}

}
