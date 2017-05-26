package list;

import java.util.HashMap;

public class CheckIntersect {

	public static class Node {
		Node next;
		int value;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
	 * 
	 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)
	 * 
	 * @param head
	 * @return
	 */
	public static Node getLoopNode(Node head) {
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

	public static boolean getLoopNode1(Node head) {
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
	/*
	 * public static void main(String[] args) { Node n1 = new Node(1); Node n2 =
	 * new Node(2); Node n3 = new Node(3); Node n4 = new Node(4); Node n5 = new
	 * Node(5);
	 * 
	 * n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; // n5.next = n1;
	 * // 构造一个带环的链表,去除此句表示不带环
	 * 
	 * System.out.println(getLoopNode(n1)); }
	 */

	/**
	 * * 现在有两个无环单链表，若两个链表的长度分别为m和n，
	 * 
	 * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */

	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		// 走到最后 如果最后的节点不相等，则他们没有相交
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;// 大于0说明1长 小于0说明2长
		cur2 = cur1 == head1 ? head2 : head1;// 如果cur1 = head1说明1长 则cur2 = head2
												// 否则2长的话cur1 = head
												// 2;cur2=head1
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;// 把长的那一块先走完
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public boolean checkNoLoop(Node headA, Node headB) {

		if (headA == null || headB == null)
			return false;
		int n = 0;
		Node cur1 = headA;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		Node cur2 = headB;
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		return cur1 == cur2;
	}

	/**
	 * * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
	 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
	 * 
	 * @param head1
	 * @param loop1
	 * @param head2
	 * @param loop2
	 */

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		// 在环之前相交
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			// 将loop作为终点
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			// loop1 != loop2
			cur1 = loop1;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}

	}

	/**
	 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
	 */

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;

	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
