package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NumCount {

	public static void main(String[] args) {
		String[] str = new String[] { "aaa", "bbb", "ccc", "ddd", "ddd", "aaa" };

		Map<String, Integer> map = new HashMap<>();
		for (String string : str) {
			Integer num = map.get(string);
			map.put(string, num == null ? 1 : num + 1);
		}
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
			System.out.println("单词 " + entry.getKey() + " 出现次数 : " + entry.getValue());
		}
	}
}
