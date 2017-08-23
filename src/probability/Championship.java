package probability;

/**
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 * 
 * @author dell
 *
 */
public class Championship {
	// 例：8支队伍，3强，
	// 1.首先求出8支队伍分成4组比赛的方法数：任选一个进入第一组，还剩7种选择..7*5*3*1=105种
	// 2.没有两强相遇的方法数：在5弱中选出3个跟强队配对，剩下的自行配对，C（5,3）*A（3,3）=60
	// 3.两强不相遇的方法数为(105-60)/105=3/7

	public int[] calc(int k) {
		// 总的分组方法有(2k-1)*(2k-3)*...*(1)种
		int total = 1;
		for (int i = 2 * k - 1; i >= 1; i = i - 2) {
			total *= i;
		}
		// 两强不相遇的分组方法有：C(k+1,k-1)*A(k-1,k-1)=(k+1)!/2
		int notMeet = 1;
		for (int i = 1; i <= k + 1; i++) {
			notMeet *= i;
		}
		notMeet = notMeet / 2;

		// 两强相遇的分组
		int meet = total - notMeet;
		int gcd = gcd(meet, total);
		int[] res = new int[2];
		res[0] = meet / gcd;
		res[1] = total / gcd;
		return res;
	}

	// 辗转相除法求最大公约数
	/*
	 * a/b=c,a是被除数，b是除数，c是商。 如果说a除b，那么a是除数，b是被除数。 如果说a除以b，那么a是被除数，b是除数。
	 */
	/*
	 * 用辗转相除法求两个数的最大公约数的步骤如下： 先用小的一个数除大的一个数，得第一个余数； 再用第一个余数除小的一个数，得第二个余数；
	 * 又用第二个余数除第一个余数，得第三个余数； 这样逐次用后一个数去除前一个余数，直到余数是0为止。
	 * 那么，最后一个除数就是所求的最大公约数（如果最后的除数是1，那么原来的两个数是互质数）。
	 * 
	 * 另外，a和b(假设a<b)的最小公倍数可以用a*b/gcd(a,b)求出。
	 */
	private int gcd(int meet, int total) {
		if (meet % total == 0) {
			return total;
		}
		return gcd(total, meet % total);
	}
}
