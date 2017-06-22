package list;

/**
 * 环形单链表的约瑟夫问题
 * 
 * @author dell
 *
 */
public class josephusKill {

	public static Node josephusKill1(Node head, Integer m) {
		int len = 0;
		Node last = head;
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		while (last.next != null) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == m) {
				head.next = last.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	public static Node josephusKill2(Node head, Integer m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;// 长度
		while (cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);
		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	public static int getLive(int i, int m) {
		if (i == 1) {
			return i;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}

	public static void printCircularList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = head1;
		printCircularList(head1);
		head1 = josephusKill1(head1, 3);
		printCircularList(head1);

		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = head2;
		printCircularList(head2);
		head2 = josephusKill2(head2, 3);
		printCircularList(head2);

	}

}
