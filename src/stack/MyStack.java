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
	// 使用两个栈，一个用来保存当前栈中的元素
	private Stack<Integer> stackData;
	// 另一个用来保存每一步中的最小值
	private Stack<Integer> stackMin;

	public MyStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int nowNum) {
		if (this.stackMin.isEmpty()) {
			// 当stackMin为空时，将值压入
			stackMin.push(nowNum);
		} else if (nowNum <= this.getMin()) {
			// 当前值比stackMin中的栈顶元素（也就是最小值）小的时候，将值压入stackMin
			stackMin.push(nowNum);
		}
		// 将nowNum压入stackData
		stackData.push(nowNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		int value = stackData.pop();
		if (value == this.getMin()) {
			// 当stackData和stackMin的值相等的时候，stackMin弹出
			this.stackMin.pop();
		}
		// 否则返回value值
		return value;
	}

	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		// 根据压入和弹出规则，stackMin的栈顶元素就是栈的最小值
		return this.stackMin.peek();
	}

	// -----------方案二-----------------
	public void push2(int newNum) {
		if (stackMin.isEmpty()) {
			// stackMin为空，压入
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin2()) {
			// 小于等于最小值压入
			this.stackMin.push(newNum);
		} else {
			// 如果大于最小值，就把stackMin的栈顶元素重复压入，也就是再压一遍
			int newMin = stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}

	public int pop2() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("your stakc is empty!");
		}
		stackMin.pop();
		int value = stackData.pop();
		return value;
	}

	public int getMin2() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("your stakc is empty!");
		}
		return stackMin.peek();
	}

	// 方案一在stackMin压入的时候省空间，弹出费时间，而方案二在压入的时候费空间，弹出省时间

}
