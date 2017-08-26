package list;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 * 
 * @author dell
 *
 */
public class ReOrderArray {
	public void reOrderArray1(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
					int t = array[j];
					array[j] = array[j + 1];
					array[j + 1] = t;
				}
			}
		}
	}

	/**
	 * 与运算判断奇偶数
	 * 
	 * 如果为正数，补码与原码相同，直接看最后一位（因为数字1的前面N位均为0，跟它做与运算，前面肯定为0），奇数为1，偶数为0，与1相与，结果不变。
	 * 
	 * 如果为负数，补码转原码：保持符号位不动，其它各位取反+1，即为负数的绝对值原码全部取反+1。还是看最后1位，先取反，再+1，结果还是和原来相同。
	 * 进行与运算时还是原来的末位，所以用跟1做与运算还是保持原来的结果。
	 * 
	 * @param array
	 */
	public void reOrderArray2(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;
		int oddCount = 0, oddBegin = 0;
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1)
				oddCount++;
		}
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1)
				newArray[oddBegin++] = array[i];
			else
				newArray[oddCount++] = array[i];
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	public void reOrderArray3(int[] array) {
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		int n = array.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = array[i];
			if (temp % 2 == 1) {
				odd.add(temp);
			} else {
				even.add(temp);
			}
		}
		int m = 0;
		for (int j = 0; j < odd.size(); j++) {
			array[m] = odd.get(j);
			m++;
		}
		for (int k = 0; k < even.size(); k++) {
			array[m] = even.get(k);
			m++;
		}
	}

}
