package sort;

/**
 * 希尔排序
 * 
 * @author dell
 *
 */
public class ShellSort {

	public static int[] shellSort(int[] A) {

		if (A == null || A.length < 2)
			return A;

		int feet = A.length / 2;
		int index = 0;
		while (feet > 0) {
			for (int i = feet; i < A.length; i++) {
				index = i;
				while (index >= feet) {
					if (A[index - feet] > A[index]) {
						swap(A, index - feet, index);
						index -= feet;
					} else {
						break;
					}
				}
			}
			feet = feet / 2;
		}
		return A;
	}

	static void swap(int[] A, int m, int n) {
		int temp = A[m];
		A[m] = A[n];
		A[n] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 4, 58, 8, 9, 22, 17, 44, 55, 64, 1, 2, 7, 8, 9, 10 };
		shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
	}
}
