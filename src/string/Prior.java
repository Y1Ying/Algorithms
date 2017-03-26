package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 
 * @author dell
 *
 */
public class Prior {

	public static String lowestString(String[] strs) {
		if (strs == null && strs.length == 0) {
			return null;
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}
	// public static class MyComparator implements Comparator<String> {
	// @Override
	// public int compare(String a, String b) {
	// return (a + b).compareTo(b + a);
	// }
	// }
	//
	// public static String lowestString(String[] strs) {
	// if (strs == null || strs.length == 0) {
	// return "";
	// }
	// // 按照新的顺序排序
	// Arrays.sort(strs, new MyComparator());
	// String res = "";
	// for (int i = 0; i < strs.length; i++) {
	// res += strs[i];
	// }
	// return res;
	// }

	public static void main(String[] args) {
		String[] strs = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs));
	}

}
