package bitOperation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
 * 
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 
 * @author dell
 *
 */
public class OddAppearance {
	public int findOdd(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer arr : A) {
			Integer num = map.get(arr);
			map.put(arr, num == null ? 1 : num + 1);
		}
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
			if (entry.getValue() % 2 == 1) {
				return entry.getKey();
			}
		}
		return 0;
	}

	public int finOdd2(int[] A) {
		int eo = 0;
		for (int cur : A) {
			eo ^= cur;
		}
		return eo;
	}

	// 两个数出现了奇数次

}
