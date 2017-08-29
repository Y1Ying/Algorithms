package array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 * 
 * @author dell
 *
 */
public class reOrderArray {

	public void reOrder1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int oddCount = 0;
		int oddBegin = 0;
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				oddCount++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				newArr[oddBegin++] = arr[i];
			} else {
				newArr[oddCount++] = arr[i];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = newArr[i];
		}
	}

	public void reOrder2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; i++) {
				if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
