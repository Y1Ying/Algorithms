package sort;

/**
 * 冒泡排序：相邻的相互比较
 * 
 * @author dell
 *
 */
public class BubbletSort {

	public int[] BubbleSort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = 0; j < A.length - i - 1; j++) {
				if (A[j + 1] < A[j]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		return A;
	}
}
