package stack;

import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 
 * @author dell
 *
 */
public class TwoStack {
	private Stack<Integer> stackPush = new Stack<Integer>();
	private Stack<Integer> stackPop = new Stack<Integer>();

	int count;
	int[] result;

	public int[] twoStack(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				stackPush.push(arr[i]);
			} else {
				count++;
			}
		}
		result = new int[count];
		while (!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		int i = 0;
		while (count != 0) {
			result[i++] = stackPop.pop();
			count--;
		}
		return result;
	}
	
	
	
	public static class TwoStacksQueue {
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void add(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}
	
}
