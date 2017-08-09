package array;

/**
 * 给定一个数组，返回子数组最大累加和
 * 
 * @author dell
 *
 */
public class maxSum {

	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			max = Math.max(sum, max);
			sum = sum < 0 ? 0 : sum;
		}
		return max;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
		System.out.println(maxSum(arr1));

		int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
		System.out.println(maxSum(arr2));

		int[] arr3 = { -2, -3, -5, -1 };
		System.out.println(maxSum(arr3));

	}
}
