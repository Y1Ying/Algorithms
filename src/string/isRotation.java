package string;

/**
 * 判断两个字符串是否互为翻转词 1.判断str1和str2是否长度相等 2.如果长度相等，生成str1和str1的大字符串
 * 3.用KMP算法判断大字符串中是否含有str2
 * 
 * @author dell
 *
 */
public class isRotation {

	public static boolean isRotation(String a, String b) {
		if (a == null && b == null && a.length() != b.length()) {
			return false;
		}
		String b2 = b + b;
		return KMP.getIndexOf(b2, a) != -1;// 使用KMP算法
	}

	// 第二种方法 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
	public boolean chkRotation(String A, int lena, String B, int lenb) {
		if (lena != lenb) {
			return false;
		}
		String C = A + A;
		return C.contains(B);
	}
}
