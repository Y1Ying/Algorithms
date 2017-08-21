package recursionanddp;

/**
 * 斐波那契问题
 * 
 * @author dell
 *
 */
public class FibonacciProblem {

	/**
	 * 输入一个整数n，请你输出斐波那契数列的第n项。O（N2）
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	/**
	 * O（N）做法
	 */
	public int Fibonacci2(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int temp = 0;
		int res = 1;
		int pre = 1;
		for (int i = 3; i <= n; i++) {
			temp = res;
			res = res + pre;
			pre = temp;
		}
		return res;
	}

	/**
	 * 给定一个整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法
	 * 最后跳上第N级的情况，要么是从N-2台阶直接跨2级，要么从N-1级台阶跨1级
	 * 所以结果为跨到N-2级和N-1级台阶的方法相加S（N-2）+S（N-1）
	 */

	/**
	 * 一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该跳上一个n级的台阶总共有多少种跳法。
	 */
	public int JumpFloorII(int target) {
		if (target == 0) {
			return 0;
		} else if (target == 1) {
			return 1;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

}
