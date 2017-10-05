package other;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1,m>1）， 每段绳子的长度记为 k[0], k[1], k[2], …, k[m]。
 * 请问 k[0] * k[1] * k[2] * … * k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * @author dell
 *
 */
public class CtuMax {

	/**
	 * 动态规划解法
	 * 
	 * @param length
	 * @return
	 */
	public int maxProductCutting(int length) {
		if (length < 2) {
			return 0;
		} else if (length == 2) {
			return 1;
		} else if (length == 3) {
			return 2;
		}
		int[] products = new int[length - 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = i; j <= i / 2; j++) {
				int product = products[j] * products[j - i];
				if (max < product) {
					max = product;
				}
				products[i] = max;
			}
		}
		max = products[length];
		return max;
	}

	public static int cuttingRopeInGreedy(int length) {
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		int timesOf3 = length / 3;

		// 尽可能多的剪去长度为3的绳子
		length -= timesOf3 * 3;

		// 如果绳子最后剩下长度为4，应该剪成 2+2，而不是 3+1
		if (length == 1) {
			timesOf3 -= 1;
			return (int) Math.pow(3, timesOf3) * 2 * 2;
		} else if (length == 0) {
			return (int) Math.pow(3, timesOf3);
		}
		// length == 2
		else {
			return (int) Math.pow(3, timesOf3) * 2;
		}
	}
}
