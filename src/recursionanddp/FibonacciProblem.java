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

	/**
	 * 关于本题，前提是n个台阶会有一次n阶的跳法。分析如下: f(1) = 1 f(2) = f(2-1) + f(2-2) //f(2-2)
	 * 表示2阶一次跳2阶的次数。 f(3) = f(3-1) + f(3-2) + f(3-3) ... f(n) = f(n-1) + f(n-2)
	 * + f(n-3) + ... + f(n-(n-1)) + f(n-n)
	 * 
	 * 说明： 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。 2）n = 1时，只有1种跳法，f(1) = 1 3) n =
	 * 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 4) n =
	 * 3时，会有三种跳得方式，1阶、2阶、3阶，
	 * 那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3) 因此结论是f(3) =
	 * f(3-1)+f(3-2)+f(3-3) 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论： f(n) =
	 * f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ...
	 * + f(n-1)
	 * 
	 * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化： f(n-1) = f(0) + f(1)+f(2)+f(3) + ... +
	 * f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) f(n) = f(0) + f(1)
	 * + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1) 可以得出： f(n) =
	 * 2*f(n-1)
	 * 
	 * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为： | 1 ,(n=0 ) f(n) = | 1 ,(n=1 )
	 * | 2*f(n-1),(n>=2)
	 * 
	 * @param target
	 * @return
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
