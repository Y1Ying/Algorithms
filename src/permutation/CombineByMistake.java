package permutation;

/**
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
 * 
 * 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 * 
 * @author dell
 *
 */
public class CombineByMistake {

	// 对n封信装法设为f(n)
	// 假设第n封信放入第i个信封
	// 情况一：第i封信也放入了第n个信封中，后续为f(n-2)
	// 情况二：第i封信没有放入第n个信封中，后续为f(n-1)
	// n封信放入i个信封，i的选择有n-1种 所以总数为f(n) = (n-1)*(f(n-1)+f(n-2))
	public int countWays(int n) {
		if (n == 1) {
			return 0;
		}
		long[] arr = new long[n + 1];
		arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			arr[i] = (i - 1) * (arr[i - 1] + arr[i - 2]) % 1000000007;
		}
		return (int) arr[n];
	}
}
