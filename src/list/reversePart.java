package list;

/**
 * 反转部分单向链表
 * 
 * 给定一个单向链表的头节点head,以及两个整数from和to，在单向链表上把第from个节点到第to个节点这一部分进行反转
 * 
 * @author dell
 *
 */
public class reversePart {
	public static Node reversePart(Node head, int from, int to) {
		// 先判断是否满足1<=from<=to<N
		// 找到from-1个节点fPre和第to+1个节点tPos,tPos是要反转的前一个节点，tPos是要反转的后一个节点
		// 把反转的部分先反转，然后正确连接fPre和tPos
		// 如果fPre为null，说明反转部分是包含头结点的，则返回新的头节点，也就是没反转部分的最后一个节点
		// 即反转部分的第一个节点，如果fPre不为null,则返回旧的头结点

		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len) {
			return head;
		}
		node1 = fPre == null ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while (node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;
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
		Node head = null;
		printLinkedList(head);
		head = reversePart(head, 1, 1);
		printLinkedList(head);

		head = new Node(1);
		printLinkedList(head);
		head = reversePart(head, 1, 1);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		head = reversePart(head, 1, 2);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		printLinkedList(head);
		head = reversePart(head, 3, 6);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		head = reversePart(head, 1, 3);
		printLinkedList(head);

	}

}
