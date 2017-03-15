package sort;

/**
 * 插入排序：后面的一次和前面已经排好的序列中比较，插入到合适的位置
 * 
 * @author dell
 *
 */
public class InsertionSort {
	public int[] insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {

			for (int j = i; (j > 0) && (A[j] < A[j - 1]); j--) {
				int temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
			}
		}
		return A;
	}

}
