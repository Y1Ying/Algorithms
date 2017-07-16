package other;

import java.util.Scanner;

/**
 * 阶乘问题：给定一个非负整数N，返回N！结果的末尾为0的数量
 * 
 * @author dell
 *
 */
public class FactorialProblem {

	// 对每一个数i来说，处理的代价是logi(以5为底)，一共有O(N)个数 时间复杂度O（NlogN）
	public static int zeroNum1(int num) {
		if (num < 0) {
			return 0;
		}
		int res = 0;
		int cur;
		for (int i = 5; i < num + 1; i += 5) {
			cur = i;
			while (cur % 5 == 0) {
				res++;
				cur /= 5;
			}
		}
		return res;
	}

	// 时间复杂度O（logN）
	public static int zeroNum2(int num) {
		if (num < 0) {
			return 0;
		}
		int res = 0;
		while (num != 0) {
			res += num / 5;
			num /= 5;
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int cnt = cin.nextInt();
		int input;
		for (int i = 0; i < cnt; i++) {
			input = cin.nextInt();
			System.out.println(zeroNum1(input));
		}
	}
}
