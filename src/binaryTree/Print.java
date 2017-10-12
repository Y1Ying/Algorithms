package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binaryTree.PrintEdgeNodes.Node;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author dell
 *
 */
public class Print {

	public static ArrayList<ArrayList<Integer>> Print(Node pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<Node> layer = new LinkedList<Node>();
		ArrayList<Integer> layerList = new ArrayList<Integer>();
		layer.add(pRoot);
		int start = 0, end = 1;
		while (!layer.isEmpty()) {
			Node cur = layer.remove();
			layerList.add(cur.value);
			start++;
			if (cur.left != null) {
				layer.add(cur.left);
			}
			if (cur.right != null) {
				layer.add(cur.right);
			}
			if (start == end) {
				end = layer.size();
				start = 0;
				result.add(layerList);
				layerList = new ArrayList<Integer>();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.right = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.left.right.left = new Node(7);
		head.left.right.right = new Node(8);
		head.right.left.left = new Node(9);
		head.right.left.right = new Node(10);
		head.left.right.right.right = new Node(11);
		head.right.left.left.left = new Node(12);
		head.left.right.right.right.left = new Node(13);
		head.left.right.right.right.right = new Node(14);
		head.right.left.left.left.left = new Node(15);
		head.right.left.left.left.right = new Node(16);

		System.out.println(Print(head));

	}
}
