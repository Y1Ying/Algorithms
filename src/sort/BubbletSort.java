package sort;

import java.util.Arrays;

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

	public static void sort(int[] arr) {
		boolean sorted = true;
		for (int j = 0; j < arr.length - 1; j++) { // 趟数
			sorted = true; // 假定有序
			System.out.println("第" + (j + 1) + "趟");
			for (int i = 0; i < arr.length - j - 1; i++) { // 在这里减j
				System.out.println("第" + (i + 1) + "次"); // 次数
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false; // 假定失败
				}
				System.out.println(Arrays.toString(arr));
			}
			if (sorted) { // 减少趟数
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 1, 2, 3, 4, 12, 44, 5, 6, 77, 34, 11, 22, 22 };
		sort(arr);
	}

}
