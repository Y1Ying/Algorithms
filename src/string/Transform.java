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
	public static boolean isDeformation(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[] arr = new int[256];
		for (int i = 0; i < chas1.length; i++) {
			// 字符做数组的索引转化为相应的asc码，这里++的意思是统计字符出现的次数
			arr[chas1[i]]++;
		}
		for (int i = 0; i < chas2.length; i++) {
			if (arr[chas2[i]]-- == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "gfedcba";
		System.out.println(isDeformation(s1, s2));
	}
}
