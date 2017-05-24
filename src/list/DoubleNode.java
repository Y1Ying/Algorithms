package list;

/**
 * 双链表
 * 
 * @author dell
 *
 */

public class DoubleNode {
	public int value;
	// 上一个节点
	public DoubleNode last;
	// 下一个节点
	public DoubleNode next;

	public DoubleNode(int data) {
		this.value = data;
	}
}
