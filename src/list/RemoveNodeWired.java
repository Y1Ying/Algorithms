package list;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。不给定整个链表的头结点
 * 
 * @author dell
 *
 */
public class RemoveNodeWired {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public void removeNodeWired(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		node.value = next.value;
		node.next = next.next;

	}

}
