package string;

import java.util.LinkedHashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * @author dell
 *
 */
public class FirstNotRepeatingChar {

	public int FirstNotRepeatingChar(String str) {
		if (str == null) {
			return -1;
		}
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				int time = map.get(str.charAt(i));
				// 注意:如果是time++则失败
				map.put(str.charAt(i), ++time);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		int i = 0;
		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.get(c) == 1) {
				return i;
			}
		}
		return -1;
	}

}
