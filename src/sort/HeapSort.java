package sort;

/**
 * 堆排序
 * 
 * @author dell
 *
 */
public class HeapSort {

	public int[] heapSort(int[] A) {
		for (int i = A.length / 2; i >= 0; i--) {
			heapAdjust(A, i, A.length);
		}
		for (int i = A.length - 1; i > 0; i--) {
			swap(A, 0, i);
			heapAdjust(A, 0, i);
		}
		return A;
	}

	void heapAdjust(int[] A, int index, int length) {
		int temp = A[index];
		for (int j = 2 * index + 1; j < length; j = j * 2 + 1) {
			if (j < length - 1 && A[j] < A[j + 1])
				j++;
			if (temp > A[j])
				break;
			A[index] = A[j];
			index = j;
		}
		A[index] = temp;
	}

	static void swap(int[] A, int m, int n) {
		int temp = A[m];
		A[m] = A[n];
		A[n] = temp;
	}
}
