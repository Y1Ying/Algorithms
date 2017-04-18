package sort;

/**
 * 快速排序
 * 
 * @author dell
 *
 */
public class QuickSort {

	public static void quickSort(int[] arr) {
		quick(arr, 0, arr.length - 1);
	}

	private static void qsort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high); // 将数组分为两部分
			qsort(arr, low, pivot - 1); // 递归排序左子数组
			qsort(arr, pivot + 1, high); // 递归排序右子数组
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low]; // 枢轴记录
		while (low < high) {
			// 从右往左遍历
			while (low < high && arr[high] >= pivot) {
				--high;
			}
			arr[low] = arr[high]; // 交换比枢轴小的记录到左端
			while (low < high && arr[low] <= pivot) {
				++low;
			}
			arr[high] = arr[low]; // 交换比枢轴大的记录到右端
		}
		// 扫描完成，枢轴到位
		arr[low] = pivot;
		// 返回的是枢轴的位置
		return low;
	}

	public static int[] quick(int[] arr, int left, int right) {
		if (left < right) {
			// 初始化保存基元
			int key = arr[left];
			int j = 0;
			int i = left;
			for (j = left + 1; j <= right; j++) {
				// 如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
				if (arr[j] < key) {
					int temp = arr[j];
					arr[j] = arr[i + 1];
					arr[i + 1] = temp;
					i++;
				}
			}
			// 交换i处元素和基元
			arr[left] = arr[i];
			arr[i] = key;
			quick(arr, left, i - 1);
			quick(arr, i + 1, right);

		}
		return arr;
	}

	public static void main(String[] args) {
		int[] a = { 4, 58, 8, 9, 22, 17, 44, 55, 64, 1, 2, 7, 8, 9, 10 };
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
	}
}
