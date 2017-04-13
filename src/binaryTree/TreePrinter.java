package binaryTree;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
	给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，
	且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * @author dell
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class TreePrinter {

	public class Node {
		int val = 0;
		Node left = null;
		Node right = null;

		public Node(int val) {
			this.val = val;
		}
	}

	public int[][] printTree(Node root) {
		if (root == null) {
			return null;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> layer = new ArrayList<ArrayList<Integer>>();
		Node last = root;
		Node nlast = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();// 出队，将孩子添加进去
			arr.add(temp.val);
			if (temp.left != null) {
				queue.add(temp.left);// 每入队一个节点，就更新nlast
				nlast = temp.left;
			}
			if (temp.right != null) {
				queue.add(temp.right);
				nlast = temp.right;
			}
			if (temp == last) {// last出队时，更新last为last的右节点，也就是最新的nlast
				layer.add(arr);
				arr = new ArrayList<Integer>();
				last = nlast;
			}
		}
		int[][] num = new int[layer.size()][];
		for (int i = 0; i < layer.size(); i++) {
			num[i] = new int[layer.get(i).size()];// 数组赋值前要确定长度
			for (int j = 0; j < layer.get(i).size(); j++) {
				num[i][j] = layer.get(i).get(j);
			}
		}
		return num;
	}
}
