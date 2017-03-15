package sort;

/**
 * 选择排序：不断选择最小的放在前面
 * 
 * @author dell
 *
 */
public class SelectionSort {

	public int[] selectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					int temp = min;
					min = a[j];
					a[j] = temp;
				}
			}
			a[i] = min;
		}
		return a;
	}
}
