package array;

import java.util.LinkedList;

/**
 * 用两个队列实现栈
 * 
 * @author dell
 *
 */
public class UseQueueImplStack {

	/**
	 * 如果有两个队列Q1和Q2，当二者都为空时。入栈操作能够用入队操作来模拟，能够随便选一个空队列，如果选Q1进行入栈操作。如今如果a,b,c依次入栈了
	 * （即依次进入队列Q1）。这时如果想模拟出栈操作，则须要将c出栈。由于在栈顶。这时候能够考虑用空队列Q2，将a，b依次从Q1中出队，而后进入队列Q2
	 * ，将Q1的最后一个元素c出队就可以。此时Q1变为了空队列。Q2中有两个元素，队头元素为a。队尾元素为b。接下来如果再运行入栈操作，
	 * 则须要将元素进入到Q1和Q2中的非空队列，即进入Q2队列，出栈的话，就跟前面的一样。将Q2除最后一个元素外所有出队，并依次进入队列Q1，
	 * 再将Q2的最后一个元素出队就可以。
	 */

	LinkedList<Integer> queue1 = new LinkedList<>();
	LinkedList<Integer> queue2 = new LinkedList<>();

	public void push(int num) {
		if (queue1.size() == 0 && queue2.size() == 0) {
			queue1.offer(num);
		} else if (queue1.size() == 0) {
			queue2.offer(num);
		} else {
			queue1.offer(num);
		}
	}

	public void pop() {
		if (queue1.size() != 0) {
			int length = queue1.size();
			for (int i = 0; i < length - 1; i++) {
				queue2.offer(queue1.poll());
			}
			queue1.poll();
		} else {
			int length = queue2.size();
			for (int i = 0; i < length - 1; i++) {
				queue1.offer(queue2.poll());
			}
			queue2.poll();
		}
	}

	public boolean empty() {
		return queue1.size() == 0 && queue2.size() == 0;
	}

	public int top() {
		if (queue1.size() != 0) {
			int length = queue1.size();
			for (int i = 0; i < length - 1; i++) {
				queue2.offer(queue1.poll());
			}
			int result = queue1.element();
			queue2.offer(queue1.poll());
			return result;
		} else {
			int length = queue2.size();
			for (int i = 0; i < length - 1; i++) {
				queue1.offer(queue2.poll());
			}
			int result = queue2.element();
			queue1.offer(queue2.poll());
			return result;
		}
	}

}
