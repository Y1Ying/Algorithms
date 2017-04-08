package array;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 
 * @author dell
 *
 */
public class LeftMostAppearance {

	public int findPos(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > num) {
				right = mid - 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else if (arr[mid] == num) {
				index = mid;
				right = mid - 1;
			}
		}
		return index;

	}
}
