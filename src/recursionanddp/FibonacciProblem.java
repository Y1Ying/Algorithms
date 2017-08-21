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

}
