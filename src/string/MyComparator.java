package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接顺序，使得所有的字符串 拼接起来组成的大写字符串是所有可能性中字典顺序最小的，并返回这个大写字符串
 * 
 * @author dell
 *
 */
public class MyComparator implements Comparator<String> {

	// 如果str1+str2<str2+str1，则str1放在前面，否则，str2放在前面

	@Override
	public int compare(String a, String b) {
		return (a + b).compareTo(b + a);
	}

	public String lowerString(String[] strs) {
		if (strs == null && strs.length == 0) {
			return "";
		}
		// 根据新的比较方式排序
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

}
