package list;

/**
 * 给定链表的头节点，删除链表的中间节点的函数
 * 
 * @author dell
 *
 */
public class removeMidNode {

	public static Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		// 链表长度每增加2，要删除的节点就后移一位
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		// pre确定要删除的对象的前一个节点，cur确定边界
		pre.next = pre.next.next;
		return head;
	}

	// 进阶题目：给定链表的头结点head,整数a和整数b，实现删除位于a/b处节点的函数
	public static Node removeByRatio(Node head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}
		int k = 0;
		Node cur = head;
		while (cur != null) {
			k++;
			cur = cur.next;
		}
		// a/b为比例，k为链表的长度，得到要删除第几个节点
		int r = (int) Math.ceil(((double) (a / b) * (double) k));
		if (r == 1) {
			head = head.next;
		}
		if (r > 1) {
			cur = head;
			// 定位到要删除的节点的前一个节点
			while (--r != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
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

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printLinkedList(head);
		head = removeMidNode(head);
		printLinkedList(head);
		head = removeByRatio(head, 2, 5);
		printLinkedList(head);
		head = removeByRatio(head, 1, 3);
		printLinkedList(head);

	}
}
