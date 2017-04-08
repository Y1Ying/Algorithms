package array;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 
 * 给定数组arr及它的大小n，请返回最小值。
 * 
 * @author dell
 *
 */
public class MinValue {
	public int getMin(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		} else if (arr.length == 1) {
			// 当数组只有两个值的时候
			return arr[0];
		}

		int right = arr.length - 1;
		int left = 0;
		int mid = 0;

		while (left < right) {

			if (arr[left] < arr[right]) {
				// 有序 左边小于右边
				return arr[left];
			}
			// 有循环部分
			mid = left + (right - left) / 2;

			if (arr[mid] < arr[left]) {
				// 最小值在Mid的左边
				right = mid;
			} else if (arr[mid] > arr[right]) {
				// 最小值在Mid的右边 说明arr[mid]不是循环的一部分
				left = mid + 1;
			} else {
				// arr[left]>=arr[right]&&arr[left]<=arr[mid]&&arr[mid]<=arr[right]
				// ===>arr[left] == ar[right] == arr[mid]
				int min = arr[left];
				for (int i = left; i < right; i++) {
					min = min < arr[i] ? min : arr[i];
				}
				return min;
			}

		}
		return arr[left];
	}

}
