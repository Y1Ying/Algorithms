package binaryTree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author dell
 *
 */
public class SerializeAndDeserializeTree {

	public String Serialize(Node root) {
		if (root == null) {
			return null;
		}
		StringBuffer sBuffer = new StringBuffer();
		SerializeTree(root, sBuffer);
		return sBuffer.toString();
	}

	public void SerializeTree(Node head, StringBuffer sb) {
		if (head == null) {
			sb.append("#,");
			return;
		}
		sb.append(head.value);
		sb.append(",");
		SerializeTree(head.left, sb);
		SerializeTree(head.right, sb);
	}

	int index = -1;

	public Node Deserialize(String str) {
		if (str == null) {
			return null;
		}
		String[] strings = str.split(",");
		return DeserializeTree(strings);
	}

	public Node DeserializeTree(String[] str) {
		index++;
		if (!str[index].equals("#")) {
			Node head = new Node(0);
			head.value = Integer.parseInt(str[index]);
			head.left = DeserializeTree(str);
			head.right = DeserializeTree(str);
			return head;
		}
		return null;
	}

}
