package list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author dell
 *
 */
public class MergeAddList {

	public Node Merge(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		Node cur = null;
		if (list1.value < list2.value) {
			cur = list1;
			cur.next = Merge(list1.next, list2);
		} else {
			cur = list2;
			cur.next = Merge(list1, list2.next);
		}

		return cur;
	}
}
