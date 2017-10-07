package list;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * @author dell
 *
 */
public class EntryNodeOfLoop {
	public Node NodeOfLoop(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node cur1 = head;
		Node cur2 = head;
		while (cur2 != null && cur2.next != null) {
			cur1 = cur1.next;
			cur2 = cur2.next.next;
			if (cur1 == cur2) {
				cur1 = head;
				while (cur1 != cur2) {
					cur1 = cur1.next;
					cur2 = cur2.next;
				}
				if (cur1 == cur2) {
					return cur1;
				}
			}
		}
		return null;
	}

}
