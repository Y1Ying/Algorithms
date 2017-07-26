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

	public static Node insertNum(Node head, int num) {
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
		// 如果num的值比头节点的值小就返回原来头节点，如果比头节点大就返回新的节点
		return head.value < num ? head : node;
	}

	public static void printCircularList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head = null;
		head = insertNum(head, 2);
		printCircularList(head);
		head = insertNum(head, 1);
		printCircularList(head);
		head = insertNum(head, 4);
		printCircularList(head);
		head = insertNum(head, 3);
		printCircularList(head);
		head = insertNum(head, 5);
		printCircularList(head);
		head = insertNum(head, 0);
		printCircularList(head);

	}

}
