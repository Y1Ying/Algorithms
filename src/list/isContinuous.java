package list;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的，2-10为数字本身， A为1，J为11，Q为12，K为13而大小王可以看成任意数字
 * 
 * @author dell
 *
 */
public class isContinuous {

	public static boolean continuous(int[] numbers) {
		int numOfZero = 0;
		int numOfInterval = 0;
		int length = numbers.length;
		if (length == 0) {
			return false;
		}
		Arrays.sort(numbers);
		for (int i = 0; i < length - 1; i++) {
			// 计算癞子数量
			if (numbers[i] == 0) {
				numOfZero++;
				continue;
			}
			// 对子，直接返回
			if (numbers[i] == numbers[i + 1]) {
				return false;
			}
			numOfInterval += numbers[i + 1] - numbers[i] - 1;
		}
		if (numOfZero >= numOfInterval) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 4 };
		System.out.println(continuous(arr));
	}
}
