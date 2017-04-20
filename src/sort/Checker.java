package sort;

/**
 * 判断数组中是否有重复值。
 * 
 * @author dell
 *
 */
public class Checker {
	public boolean checkDuplicate(int[] arr, int n) {
		if (arr == null || n < 2) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int temp1 = arr[i];
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				int temp2 = arr[j];
				if (temp1 == temp2) {
					count++;
				}
			}
			if (count >= 2) {
				flag = true;
			}
		}
		return flag;
	}

}
