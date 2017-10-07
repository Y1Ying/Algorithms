package binaryTree;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author dell
 *
 */
public class isSymmetrical {

	public boolean isSymmetrical(Node head) {
		if (head == null) {
			return true;
		}
		return Symmetrical(head.left, head.right);
	}

	public boolean Symmetrical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 != null && root2 != null)
			return root1.value == root2.value && Symmetrical(root1.left, root2.right)
					&& Symmetrical(root1.right, root2.left);

		return false;

	}

}
