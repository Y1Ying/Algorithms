package permutation;

/**
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，
 * 他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。 现在问你满足A的要求的对列有多少种？
 * 
 * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 * 
 * @author dell
 *
 */
public class LonelyA {
	// N个人全排列总数为n!，其中a与b相邻总数为（将ab和ba看做一个人）=(n-1)*2!
	// 其中a与c相邻的总数为（将ac和ca看做一个人）= （n-1）*2!
	// 这其中有bac和cab两种情况被包含进去（将三个看成一个人,多减了一次） = (n-2)!*2
	// 所以结果为n!-(n-1)!-(n-1)!+(n-2)!*2
	public int getWays(int n, int A, int b, int c) {
		if (n == 0) {
			return 0;
		}
		return go(n) - (go(n - 1) * 4) + (go(n - 2) * 2);
	}

	public int go(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

}
