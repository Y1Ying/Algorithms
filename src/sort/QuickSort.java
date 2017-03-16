package sort;

/**
 * 快速排序
 * 
 * @author dell
 *
 */
public class QuickSort {

	public static int[] quickSort(int[] A) {
		quick(A, 0, A.length - 1);
		return A;
	}

	private static int[] quick(int[] A, int low, int high) {
		if (low < high) {
			int mid = sort(A, low, high);
			quick(A, low, mid - 1);
			quick(A, mid + 1, high);
		}
		return A;
	}

	private static int sort(int[] A, int low, int high) {
		int key = A[low];
		int i = low;
		int j = high;
		if (low < high) {
			while (i < j) {
				while (i < j && key <= A[j]) {
					j--;
				}
				if (i < j) {
					A[i] = A[j];
				}
				while (i < j && A[i] <= key) {
					i++;
				}
				if (i < j) {
					A[j] = A[i];
				}
			}
			A[i] = key;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] a = { 4, 58, 8, 9, 22, 17, 44, 55, 64, 1, 2, 7, 8, 9, 10 };
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
	}
}
