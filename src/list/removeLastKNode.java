package list;

/**
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表倒数第K个节点
 * 
 * @author dell
 *
 */
public class removeLastKNode {

	// 单链表
	public static Node removeLastKthNode(Node head, int lastKth) {
		// 当头结点为空或者k<1时返回单链表
		if (head == null || lastKth < 1) {
			return head;
		}
		Node cur = head;
		// 从头走到尾，k-1;分三种情况
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		// 走到最后k=0,说明是第一个节点，删掉头结点就可以
		if (lastKth == 0) {
			head = head.next;
		}
		// 小于0时，从头到尾再走一遍，当k=0时，说明走到了要删掉的节点的前面
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	/**
	 * 如果链表长度为N，要删除倒数第K个节点，倒数第K个节点的前一个节点是N-K个，第一次
	 * 遍历之后，K的值变为K-N，第二次遍历的时，K的值不断+1，加到0停止 会停到第N-K个节点
	 * 
	 * @param head
	 * @param lastKth
	 * @return
	 */

	public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		DoubleNode cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
			head.last = null;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if (newNext != null) {
				newNext.last = cur;
			}
		}
		return head;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		printLinkedList(head1);
		head1 = removeLastKthNode(head1, 3);
		// head1 = removeLastKthNode(head1, 6);
		// head1 = removeLastKthNode(head1, 7);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		head2.next.next.next.next = new DoubleNode(5);
		head2.next.next.next.next.last = head2.next.next.next;
		head2.next.next.next.next.next = new DoubleNode(6);
		head2.next.next.next.next.next.last = head2.next.next.next.next;
		printDoubleLinkedList(head2);
		head2 = removeLastKthNode(head2, 3);
		// head2 = removeLastKthNode(head2, 6);
		// head2 = removeLastKthNode(head2, 7);
		printDoubleLinkedList(head2);

	}
}
