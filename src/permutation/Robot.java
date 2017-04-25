package permutation;

/**
 * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 * 
 * C(n,r) = n! / r!(n-r)!
 * 
 * @author dell
 *
 */
public class Robot {

	public int countWays(int x, int y) {
		// 肯定要往下走y-1步，往右走x-1步
		int n = x + y - 2;
		int m = x - 1;// 此处是y-1结果也相同
		int res = Factorial(n) / (Factorial(m) * Factorial(n - m));
		return res;
	}

	public int Factorial(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
