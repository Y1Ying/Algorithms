package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
	 * 则打印出这三个数字能排成的最小数字为321323。
	 * 
	 * @param arr
	 * @return
	 */
	public String PrintMinNumber(int[] arr) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i] + "");
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				return (a + b).compareTo(b + a);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
		}
		return sb.toString();
	}

}
