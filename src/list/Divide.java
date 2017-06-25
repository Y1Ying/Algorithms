package list;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 
 * @author dell
 *
 */
public class Divide {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static Node ListDivide(Node head, int num) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		// 获取链表长度
		while (cur != null) {
			cur = cur.next;
			i++;
		}
		// 生成Node数组 遍历
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrpartition(nodeArr, num);
		// 重新连接
		for (i = 1; i < nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];

	}

	/**
	 * 改进快排调整过程
	 * 
	 * @param nodeArr
	 * @param num
	 */
	public static void arrpartition(Node[] nodeArr, int num) {
		if (nodeArr == null || nodeArr.length < 2) {
			return;
		}
		int left = -1;
		int index = 0;
		int right = nodeArr.length;
		while (index != right) {
			if (nodeArr[index].value < num) {
				swap(nodeArr, ++left, index++);
			} else if (nodeArr[index].value > num) {
				swap(nodeArr, --right, index);
			} else {
				index++;
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node temp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = temp;
	}

	// 保证两类结点内部的位置关系不变
	public static Node listPartition2(Node head, int num) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		Node next = null; // save next node
		// every node distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < num) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == num) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// small and equal reconnect
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// all reconnect
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = ListDivide(head1, 4);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}
}
