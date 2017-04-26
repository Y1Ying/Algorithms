package permutation;

/**
 * 卡特兰数问题集合
 * 
 * 问题1：假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 * 
 * 问题2：n个数进出栈的顺序有多少种？假设栈的容量无限大。
 * 
 * 问题3：2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
 * 
 * 问题4：求n个无差别的节点构成的二叉树有多少种不同的结构？
 * 
 * 问题5：12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？ 如果前缀1比0
 * 的个数多，出现非法问题，问题转换成：任意前缀中，0的个数不小于1的个数
 * 
 * @author dell
 *
 */
public class Catalan {

	// 此类问题可归为一种：卡特兰数：C(n,2n)-C(n+1,2n) = C(n,2n)/(n+1)
	public int countWays(int n) {
		return (int) (getCr(n, 2 * n) / (n + 1));
	}

	public static long getCr(int r, int n) {
		return getCK(n) / (getCK(r) * getCK(n - r));
	}

	public static long getCK(int n) {
		if (n == 0) {
			return 0;
		}
		long i = n - 1;
		long n2 = n;
		while (i > 0) {
			n2 *= i;
			i--;
		}
		return n2;

	}

	// 问题5：
	public int countWays5(int n) {
		n = n / 2; // 此处不同
		return (int) (getCr(n, 2 * n) / (n + 1));
	}
}
