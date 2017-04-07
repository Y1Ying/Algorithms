package list;

import java.util.HashMap;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 
 * @author dell
 *
 */
public class ChkLoop {

	public static class Node {
		Node next;
		int value;

		public Node(int data) {
			this.value = data;
		}
	}

	public Node getLoopNode1(Node head) {
		if (head == null && head.next == null && head.next.next == null) {
			return null;
		}

		Node quick = head.next.next;
		Node slow = head.next;

		while (quick != slow) {
			if (quick.next.next == null || quick.next == null) {
				return null;
			}
			quick = quick.next.next;
			slow = slow.next;
		}
		quick = head;
		while (quick != slow) {
			quick = quick.next;
			slow = slow.next;
		}
		return slow;
	}

	public static boolean getLoopNode2(Node head) {
		if (head == null) {
			return false;
		}
		Node cur = head;
		HashMap<Node, Node> map = new HashMap<>();
		while (cur != null) {
			if (map.get(cur) != null) {
				return true;
			} else {
				map.put(cur, cur);
			}
			cur = cur.next;
		}
		return false;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		// n5.next = n1; // 构造一个带环的链表,去除此句表示不带环

		System.out.println(getLoopNode2(n1));
	}

}
