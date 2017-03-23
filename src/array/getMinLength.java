package array;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 
 * @author dell
 *
 */
public class getMinLength {
	public int getMinLength(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		// 从右往左找到最小
		int min = arr[arr.length - 1];
		int noMinIndex = -1;
		for (int i = arr.length - 2; i != -1; i--) {
			if (arr[i] > min) {
				noMinIndex = i;
			} else {
				min = Math.min(arr[i], min);
			}
		}
		// 从左往右找最大
		int max = arr[0];
		int noMaxIndex = -1;
		for (int j = 1; j != arr.length; j++) {
			if (arr[j] < max) {
				noMaxIndex = j;
			} else {
				max = Math.max(arr[j], max);
			}
		}
		return noMaxIndex - noMinIndex + 1;
	}

}
