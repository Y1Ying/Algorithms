package array;

/**
 * 数组的partition调整
 * 
 * 给定一个有序数组arr，调整arr使得整个数组的左半部分没有重复元素且升序，不用保证右部分有序
 * 
 * @author dell
 *
 */
public class Partition {

	public void leftUnique(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int u = 0;
		int i = 1;
		while (i != arr.length) {
			if (arr[i++] != arr[u]) {
				int temp = arr[++u];
				arr[++u] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}
	}
}
