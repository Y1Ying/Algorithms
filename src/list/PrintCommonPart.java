package list;

/**
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * 
 * @author dell
 *
 */
public class PrintCommonPart {

	// 由于是有序链表，所以两个链表的头开始进行：
	// 如果head1的值小于head2,则head1往下移动
	// 如果head2的值小于head1,则head2往下移动
	// 如果相等，打印这个值，两个一起往下移动，直到有一个移动到Null

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public void printCommonPart(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value < head2.value) {
				head2 = head2.next;
			} else {
				System.out.println(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
}
