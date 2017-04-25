package permutation;

/**
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 * 
 * @author dell
 *
 */

public class Distribution {

	// n个糖果，中间有n-1个空间放m-1个隔板 结果就是C((n-1)(m-1));
	public int getWays(int n, int m) {
		int i = m - 1;
		int j = n - 1;
		return go(j) / (go(i) * go(j - i));
	}

	public int go(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
