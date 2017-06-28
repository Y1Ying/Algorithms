package list;

import java.util.Stack;

public class AddTwoList {

	// 第一种方法：在链表较大时候出现溢出
	public static Node addList1(Node head1, Node head2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (head1 != null) {
			s1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			s2.push(head2.value);
			head2 = head2.next;
		}
		// 进位
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node node = null;
		Node pre = null;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}

		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}

	// 链表逆序方法
	public static Node addList2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int n = 0;
		int n1 = 0;
		int n2 = 0;
		int ca = 0;
		Node c1 = null;
		Node c2 = null;
		Node node = null;
		Node pre = null;
		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.value : 0;
			n2 = c2 != null ? c2.value : 0;
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverseList(head1);
		reverseList(head2);
		return node;

	}

	public static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
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
		Node head1 = new Node(9);
		head1.next = new Node(9);
		head1.next.next = new Node(9);

		Node head2 = new Node(1);

		printLinkedList(head1);
		printLinkedList(head2);
		printLinkedList(addList1(head1, head2));
		printLinkedList(addList2(head1, head2));

	}

}
