package array;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author dell
 *
 */
public class MoreThanHalfNum {
	/**
	 * 数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
	 * 这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
	 * 
	 * @param array
	 * @return
	 */

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// 因为用到了sort，时间复杂度O(NlogN)，并非最优
		Arrays.sort(array);
		// 出现次数
		int count = 0;
		// 排序，取数组中间那个数
		int mid = array[array.length / 2];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == mid) {
				count++;
			}
		}
		return count > array.length / 2 ? mid : 0;
	}

	/**
	 * 思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
	 * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，
	 * 则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
	 * 
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1
		int number = array[0];
		int time = 1;// 次数
		for (int i = 0; i < array.length; i++) {
			if (time == 0) {
				// 更新number的值为当前元素，并置次数为1
				number = array[i];
				time = 1;
			} else if (number == array[i]) {
				time++;// 相同则加1
			} else {
				time--;// 不同则减1
			}
		}
		// 判断result是否符合条件，即出现次数大于数组长度的一半
		time = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				time++;
			}
		}
		return time > array.length / 2 ? number : 0;
	}
}
