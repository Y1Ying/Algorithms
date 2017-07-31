package binaryTree;

/**
 * 给定一颗二叉树的头节点head,按照如下两种标准分别实现二叉树边界节点的逆时针打印
 * 
 * 标准一：1.头结点为边界结点2.叶节点为边界节点3.如果在其所在的层中是最左或者最右的，那么也是边界节点
 * 标准二：1.头结点为边界结点2.叶节点为边界节点3.树左边界延伸下去的路径为边界节点4.树右边界延伸下去的路径为边界节点
 * 
 * @author dell
 *
 */
public class PrintEdgeNodes {

	// 标准一
	public void printEdge1(Node head) {
		if (head == null) {
			return;
		}
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		// 打印左边界
		for (int i = 0; i != edgeMap.length; i++) {
			System.out.println(edgeMap[i][0].val + " ");
		}
		// 打印既不是左边界，也不是右边界的叶子结点
		printLeafNotInMap(head, 0, edgeMap);
		// 打印右边界，但不是左边界的节点
		for (int i = edgeMap.length - 1; i != -1; i--) {
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].val + " ");
			}
		}
		System.out.println();
	}

	public int getHeight(Node h, int l) {
		if (h == null) {
			return l;
		}
		return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
	}

	public void setEdgeMap(Node h, int l, Node[][] edgeMap) {
		if (h == null) {
			return;
		}
		edgeMap[1][0] = edgeMap[1][0] == null ? h : edgeMap[1][0];
		edgeMap[1][1] = h;
		setEdgeMap(h.left, l + 1, edgeMap);
		setEdgeMap(h.right, l + 1, edgeMap);
	}

	public void printLeafNotInMap(Node h, int l, Node[][] m) {
		if (h == null) {
			return;
		}
		if (h.left == null && h.right == null && h != m[l][0] && h != m[l][l]) {
			System.out.println(h.val + " ");
		}
		printLeafNotInMap(h.left, l + 1, m);
		printLeafNotInMap(h.right, l + 1, m);
	}
}
