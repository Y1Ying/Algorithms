package string;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
 * 
 * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 
 * @author dell
 *
 */
public class Transform {

	// 用数组
	public boolean isDeformation(String str1, String str2) {
		if (str1 == null && str2 == null && str1.length() != str2.length()) {
			return false;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < chas1.length; i++) {
			map[chas1[i]]++;
		}
		for (int i = 0; i < chas2.length; i++) {
			if (map[chas2[i]]-- == 0) {
				return false;
			}
		}
		return true;

	}
}
