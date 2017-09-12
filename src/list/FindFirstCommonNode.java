package list;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author dell
 *
 */
public class FindFirstCommonNode {

	public Node FindFirstCommonNode1(Node pHead1, Node pHead2) {
		Node cur1 = pHead1;
		Node cur2 = pHead2;
		HashMap<Node, Integer> map = new HashMap<Node, Integer>();
		while (cur1 != null) {
			map.put(cur1, null);
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			if (map.containsKey(cur2)) {
				return cur2;
			}
			cur2 = cur2.next;
		}
		return null;

	}

	public Node FindFirstCommonNode2(Node pHead1, Node pHead2) {
		Node current1 = pHead1;// 链表1
		Node current2 = pHead2;// 链表2
		if (pHead1 == null || pHead2 == null)
			return null;
		int length1 = getLength(current1);
		int length2 = getLength(current2);
		// 两连表的长度差

		// 如果链表1的长度大于链表2的长度
		if (length1 >= length2) {
			int len = length1 - length2;
			// 先遍历链表1，遍历的长度就是两链表的长度差
			while (len > 0) {
				current1 = current1.next;
				len--;
			}

		}
		// 如果链表2的长度大于链表1的长度
		else if (length1 < length2) {
			int len = length2 - length1;
			// 先遍历链表1，遍历的长度就是两链表的长度差
			while (len > 0) {
				current2 = current2.next;
				len--;
			}

		}
		// 开始齐头并进，直到找到第一个公共结点
		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;

	}

	// 求指定链表的长度
	public static int getLength(Node pHead) {
		int length = 0;

		Node current = pHead;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	/**
	 * 长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
	 * 长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
	 * 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public Node FindFirstCommonNode3(Node pHead1, Node pHead2) {
		Node cur1 = pHead1;
		Node cur2 = pHead2;

		while (cur1 != cur2) {
			cur1 = cur1 == null ? pHead2 : cur1.next;
			cur2 = cur2 == null ? pHead1 : cur2.next;
		}
		return cur1;

	}
}
