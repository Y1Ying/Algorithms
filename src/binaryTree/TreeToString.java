package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * 
 * 假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，
 * 当然你也可以用其他的特殊字符，“!”表示一个值的结束。如果遇到不为空的节点， 假设节点值为3，就在str的末尾加上“3!”。现在请你实现树的先序序列化。
 * 给定树的根结点root，请返回二叉树序列化后的字符串。
 * 
 * @author dell
 *
 */
public class TreeToString {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}

		// 序列化
		public String serialByPre(Node head) {
			if (head == null) {
				return "#!";
			}
			String res = head.value + "!";
			res += serialByPre(head.left);
			res += serialByPre(head.right);
			return res;
		}

		// 反序列化
		public Node reconByPreString(String preStr) {
			String[] values = preStr.split("!");
			Queue<String> queue = new LinkedList<String>();
			for (int i = 0; i < values.length; i++) {
				queue.offer(values[i]);
			}
			return reconPreOrder(queue);
		}

		public Node reconPreOrder(Queue<String> queue) {
			String value = queue.poll();
			if (value.equals("#")) {
				return null;
			}
			Node head = new Node(Integer.valueOf(value));
			head.left = reconPreOrder(queue);
			head.right = reconPreOrder(queue);
			return head;
		}

	}
}
