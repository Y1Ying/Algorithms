package array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author dell
 *
 */
public class minNumber {

	public int minNumberInRotateArray(int[] arr) {
		if (arr == null) {
			return 0;
		}
		// 相当于一个递增数组，采用二分法查找
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			// 说明右半部分已经是反转过去的了，最小值会出现在右边
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else if (arr[mid] == high) {
				// 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
				// 还是右边,这时只好一个一个试
				mid = high - 1;
			} else if (arr[mid] < high) {
				// 说明最小值一定出现在左边，或者就是mid
				// 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
				// 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
				// 比如 array = [4,6] array[low] = 4 ;array[mid] = 4 ; array[high]
				// = 6 ; 如果high = mid - 1，就会产生错误， 因此high = mid
				high = mid;
			}
		}
		return arr[low];
	}
}
