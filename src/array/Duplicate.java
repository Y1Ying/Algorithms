package array;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 
 * @author dell
 *
 */
public class Duplicate {

	public boolean duplicate1(int[] arr, int[] duplication) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				duplication[0] = arr[i];
				return true;
			}
		}
		return false;
	}

	public boolean duplicate2(int[] arr, int[] duplication) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		boolean[] k = new boolean[arr.length];
		for (int i = 0; i < k.length; i++) {
			if (k[arr[i]] == true) {
				duplication[0] = arr[i];
				return true;
			}
			k[arr[i]] = true;
		}
		return false;
	}

}
