package array;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * 
 * @author dell
 *
 */
public class ThreeColor {
	public int[] sortThreeColor(int[] a) {
		int n = 0;
		int m = 0;
		int k = a.length - 1;
		while (m <= k) {
			if (a[m] == 0) {
				swap(a, m, n++);
				m++;
			} else if (a[m] == 1) {
				m++;
			} else {
				swap(a, m, k--);
			}
		}
		return a;
	}

	public void swap(int[] a, int n, int m) {
		if (n != m) {
			int temp = a[n];
			a[n] = a[m];
			a[m] = temp;
		}
	}

}
