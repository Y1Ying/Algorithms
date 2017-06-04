package list;

/**
 * 反转单向链表和双向链表
 * 
 * @author dell
 *
 */
public class reverseList {

	/**
	 * 反转单向链表 保存当前头节点的下一个节点（当前头节点为2，先将节点3 保存起来） 将当前头节点的下一个节点指向 “上一个节点”（当前头节点2
	 * 指向了 (“上一个节点”)节点1），这一步才是实现反转 将当前头节点设置 “上一个节点”（将节点2 设为“上一个节点”） 将保存的下一个节点设置
	 * “头节点”（将节点3 设为“头节点”）
	 */
	public Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * 反转双向链表
	 */
	public DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
}
