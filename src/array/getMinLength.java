package array;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 
 * @author dell
 *
 */
public class getMinLength {
	public int getMinLength(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}

		int max = A[0];
		int min = A[A.length - 1];
		int noMaxIndex = 0;
		int noMinIndex = 0;

		// 从左往右找最大 遍历过的最大值比当前数大的时候记录，得到发生这种情况最右的位置

		for (int j = 0; j < A.length; j++) {
			if (A[j] < max) {
				noMaxIndex = j;
			} else if (A[j] > max) {
				max = A[j];
			}
		}
		// 从右往左找到最小，遍历过的最小值比当前数小的时候记录，得到发生这种情况最左的位置
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] > min) {
				noMinIndex = i;
			} else if (A[i] < min) {
				min = A[i];
			}
		}
		if (noMaxIndex - noMinIndex == 0) {
			return 0;
		} else {
			return noMaxIndex - noMinIndex + 1;
		}
	}

}
