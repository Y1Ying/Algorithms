package array;

public class MergeSortedArr {
	public static int[] mergeArr(int[] a, int[] b) {
		if (a == null && b == null) {
			return null;
		}
		int[] result = new int[a.length + b.length];
		int i = 0, j = 0, k = 0; // i:用于标示a数组 j：用来标示b数组 k：用来标示传入的数组
		while (i < a.length && j < b.length)
			if (a[i] <= b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}

		/* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 */
		while (i < a.length)
			result[k++] = a[i++];
		while (j < b.length)
			result[k++] = b[j++];

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9 };
		int[] b = { 2, 4, 6, 8, 10 };
		int[] res = mergeArr(a, b);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

}
