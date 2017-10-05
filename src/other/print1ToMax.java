package other;

/**
 * 输入数字n,按照顺序打印出从1到最大的n位十进制数，
 * 
 * @author dell
 *
 */
public class print1ToMax {

	public static void Print1ToMaxDigits(int n) {
		if (n < 0) {
			return;
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		print1ToMaxOfN(arr, 0);
	}

	public static void print1ToMaxOfN(int[] arr, int index) {
		if (index == arr.length) {
			printNumber(arr);
			return;
		}
		for (int i = 0; i < 10; i++) {
			arr[index] = i;
			print1ToMaxOfN(arr, index + 1);
		}
	}

	public static void printNumber(int[] arr) {
		boolean isBeginning0 = true;
		for (int i = 0; i < arr.length; i++) {
			if (isBeginning0 && arr[i] != 0) {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Print1ToMaxDigits(2);
	}
}
