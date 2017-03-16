package stack;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的 操作
 * 
 * pop,push,getMin操作的时间复杂度都是O（1） 设计栈类型可以用现成的栈结构
 * 
 * @author dell
 *
 */
public class MyStack {

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int nowNum) {
		if (this.stackMin.isEmpty()) {
			stackMin.push(nowNum);
		} else if (nowNum <= this.getMin()) {
			stackMin.push(nowNum);
		}
		stackData.push(nowNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		int value = stackData.pop();
		if (value == this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		return this.stackMin.peek();
	}
}
