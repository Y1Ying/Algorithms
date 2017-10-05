package list;

/**
 * O（1）删除链表的节点
 * 
 * @author dell
 *
 */
public class DeleteNode {

	public void removeNode(Node head, Node node) {
		if (head == null || node == null) {
			return;
		}
		// 要删除的节点不是尾节点
		if (node.next != null) {
			Node next = node.next;
			node.value = next.value;
			node.next = next.next;
		}
		// 链表只有一个节点，删除头结点
		else if (head == node) {
			head = null;
			node = null;
		}
		// 链表中有多个节点，要删除尾节点
		else {
			Node cur = head;
			while (cur.next != node) {
				cur = cur.next;
			}
			cur.next = null;
			node = null;
		}
	}
}
