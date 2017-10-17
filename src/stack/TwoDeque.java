package stack;

import java.util.LinkedList;

/**
 * 1.有两个队列q1和q2，先往q1内插入a，b，c，这做的都是栈的push操作。
 * 2.现在要做pop操作，即要得到c，这时可以将q1中的a,b两个元素全部dequeue并存入q2中，这时q2中元素为a，b，
 * 对q1再做一次dequeue操作即可得到c。 
 * 3.如果继续做push操作，比如插入d，f，则把d，f插入到q2中， 此时若要做pop操作，则做步骤2
 * 以此类推，就实现了用两个队列来实现一个栈的目的。
 * 注意在此过程中，新push进来的元素总是插入到非空队列中，空队列则用来保存pop操作之后的那些元素，那么此时空队列不为空了，原来的非空队列变为空了，
 * 总是这样循环。
 * 
 * @author dell
 *
 */

public class TwoDeque {
	LinkedList<Integer> queue1 = new LinkedList<Integer>(); // 队列1
	LinkedList<Integer> queue2 = new LinkedList<Integer>(); // 队列2

	// Push element x onto stack.
	public void push(int x) {
		if (!queue2.isEmpty()) {
			queue2.offer(x);
		} else {
			queue1.offer(x);
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!empty()) {
			if (queue1.isEmpty()) {
				while (queue2.size() > 1) {
					queue1.offer(queue2.poll());
				}
				queue2.poll();
			} else {
				while (queue1.size() > 1) {
					queue2.offer(queue1.poll());
				}
				queue1.poll();
			}
		}
	}

	// Get the top element.
	public int top() {
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) {
				queue1.offer(queue2.poll());
			}
			int x = queue2.poll();
			queue1.offer(x);
			return x;
		} else {
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			int x = queue1.poll();
			queue2.offer(x);
			return x;
		}
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

}
