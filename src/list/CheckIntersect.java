package list;

/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，
 * 
 * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 
 * @author dell
 *
 */
public class CheckIntersect {

	public static class ListNode {
		ListNode next;
		int val;

		public ListNode(int data) {
			this.val = data;
		}
	}

	public boolean chkIntersect(ListNode headA, ListNode headB) {
		int n = 0;
		int m = 0;
		ListNode cur1 = headA;
		ListNode cur2 = headB;
		while (cur1 != null) {
			cur1 = cur1.next;
			n++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			m++;
		}
		int i = 0;
		if (n > m) {
			// 链表1长
			while (i > 0 && i <= n - m) {
				cur1 = cur1.next;
				i--;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
			if (cur1.val == cur2.val) {
				return true;
			} else {
				return false;
			}
		} else if (n < m) {
			// 链表2长
			while (i > 0 && i <= m - n) {
				cur2 = cur2.next;
				i--;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
			if (cur1.val == cur2.val) {
				return true;
			} else {
				return false;
			}
		} else {
			cur1 = cur1.next;
			cur2 = cur2.next;
			if (cur1.val == cur2.val) {
				return true;
			} else {
				return false;
			}
		}
	}
}
