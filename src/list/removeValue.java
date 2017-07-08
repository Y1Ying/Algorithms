package list;

import java.util.Stack;

/**
 * 删除指定值的节点
 * 
 * @author dell
 *
 */
public class removeValue {

	/**
	 * 给定头结点，和整数Num,将值为Num的节点全部删除
	 */
	// 时间复杂度O（N） 空间复杂度O（1）
	public static Node removeValue1(Node head, int num) {
		// 从头开始遍历，找到第一个不等于Num的节点，作为新的节点
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

	// 时间复杂度O（N） 空间复杂度O（N）
	public static Node removeValue2(Node head, int num) {
		Stack<Node> stack = new Stack<>();
		while (head != null) {
			if (head.value != num) {
				stack.push(head);
			}
			head = head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
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
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue1(head, 1);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue2(head, 1);
		printLinkedList(head);

	}

}
