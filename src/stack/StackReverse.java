package stack;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 
 * @author dell
 *
 */
public class StackReverse {
	public int[] reverseStack(int[] arr, int n) {
		n = arr.length;
		if (arr == null || arr.length < 2) {
			return arr;
		}
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		reverseStack(arr, n - 1);
		arr[n - 1] = result;
		return arr;
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
