package array;

/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 
 * 如果所有位置上的数都不满足条件，返回-1。
 * 
 * @author dell
 *
 */
public class Find {

	public int findPos(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr[0] > (arr.length - 1) || arr[arr.length - 1] < 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int res = -1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] > mid) {
				right = mid - 1;
			} else if (arr[mid] < mid) {
				left = mid + 1;
			} else if (arr[mid] == mid) {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i] == i) {
		// return i;
		// } else if (arr[i] < arr[mid]) {
		// right = mid - 1;
		// } else if (arr[i] > arr[mid]) {
		// left = mid + 1;
		// }
		// }
		// return -1;
	}

}
