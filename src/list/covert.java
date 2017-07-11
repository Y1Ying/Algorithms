package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换成双向链表
 * 
 * 对每一个节点来说，原来的right指针等价于转换后的next指针 原来的left指针等价于转换后的last指针
 * 
 * @author dell
 *
 */

class Node1 {
	public int value;
	public Node1 left;
	public Node1 right;

	public Node1(int data) {
		this.value = data;
	}
}

public class covert {

	public static Node1 convert1(Node1 head) {
		Queue<Node1> queue = new LinkedList<>();
		inOrderToQueue(head, queue);
		Node1 pre = head;
		pre.left = null;
		Node1 cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public static void inOrderToQueue(Node1 head, Queue<Node1> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

	public static void printBSTInOrder(Node1 head) {
		System.out.print("BST in-order: ");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}

	public static void inOrderPrint(Node1 head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}

	public static void printDoubleLinkedList(Node1 head) {
		System.out.print("Double Linked List: ");
		Node1 end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node1 head = new Node1(5);
		head.left = new Node1(2);
		head.right = new Node1(9);
		head.left.left = new Node1(1);
		head.left.right = new Node1(3);
		head.left.right.right = new Node1(4);
		head.right.left = new Node1(7);
		head.right.right = new Node1(10);
		head.left.left = new Node1(1);
		head.right.left.left = new Node1(6);
		head.right.left.right = new Node1(8);

		printBSTInOrder(head);
		head = convert1(head);
		printDoubleLinkedList(head);

		head = new Node1(5);
		head.left = new Node1(2);
		head.right = new Node1(9);
		head.left.left = new Node1(1);
		head.left.right = new Node1(3);
		head.left.right.right = new Node1(4);
		head.right.left = new Node1(7);
		head.right.right = new Node1(10);
		head.left.left = new Node1(1);
		head.right.left.left = new Node1(6);
		head.right.left.right = new Node1(8);

		// printBSTInOrder(head);
		// head = convert2(head);
		// printDoubleLinkedList(head);

	}
}
