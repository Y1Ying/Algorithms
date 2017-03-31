package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按照从大到小的顺序排序，只许申请一个栈
 * 
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构，如果完成排序
 * 
 * @author dell
 *
 */
public class sort_stack {

	// 如果cur小于等于help栈顶元素，压入help栈中
	// 如果大于help栈顶元素，将help元素弹出，压入stack栈中,直到cur小于等于help栈顶元素，再将cur压入help
	// 一直循环，直到将stack的元素全部压入到help，在压回来
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	// 用数组模拟
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		int[] help = new int[numbers.length];
		int n = numbers.length;
		int i = 0, j = n;// 栈的当前指针
		int cur;
		while (i < n) {
			// ++为出栈，--为进栈
			// 弹出栈中的第一个元素，下移index
			cur = numbers[i++];

			if (j == n) {
				// 将弹出元素压入help栈顶
				help[--j] = cur;
			} else if (cur <= help[j]) {
				// 将弹出元素压入help栈顶
				help[--j] = cur;
			} else if (cur > help[j]) {
				// 弹出help栈中的元素，并将其压入到主栈栈顶，直到cur小于等于help栈顶元素
				while (j < n && cur > help[j]) {
					numbers[--i] = help[j++];
				}
				// 将弹出元素压入help栈顶
				help[--j] = cur;
			}

		}
		numbers[0] = help[n - 1];

		ArrayList<Integer> list = new ArrayList<>();
		for (int m = 0; m < n; m++) {
			list.add(help[n - m - 1]);
		}
		return list;
	}
}
